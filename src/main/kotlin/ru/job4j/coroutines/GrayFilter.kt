package ru.job4j.coroutines


import kotlinx.coroutines.Job
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

private const val NUM_PARTS = 4  // Количество частей для параллельной обработки

/**
 * Функция для загрузки изображения
 */
fun loadImage(path: String): BufferedImage {
    return ImageIO.read(File(path))
}

/**
 * Функция для сохранения изображения
 */
fun saveImage(image: BufferedImage, path: String) {
    ImageIO.write(image, "jpg", File(path))
}

/**
 * Функция для конвертации пикселя в оттенок серого
 */
@SuppressWarnings("detekt:MagicNumber")
fun toGrayScale(color: Color): Color {
    val grayValue = (0.3 * color.red + 0.59 * color.green + 0.11 * color.blue).toInt()
    return Color(grayValue, grayValue, grayValue)
}

/**
 * Функция для обработки части изображения в корутине
 */
fun processImagePart(
    image: BufferedImage,
    startX: Int,
    endX: Int,
    startY: Int,
    endY: Int
) {
    for (x in startX until endX) {
        for (y in startY until endY) {
            image.setRGB(x, y, toGrayScale(Color(image.getRGB(x, y))).rgb)
        }
    }
}

fun main() {
    runBlocking {
        val inputImage = loadImage("F:\\Photo.jpg")
        val width = inputImage.width
        val height = inputImage.height
        val jobs = mutableListOf<Job>()
        val partWidth = width / NUM_PARTS

        for (i in 0 until NUM_PARTS) {
            val startX = i * partWidth
            val endX = if (i == NUM_PARTS - 1) width else (i + 1) * partWidth

            val job = launch {
                processImagePart(inputImage, startX, endX, 0, height)
            }
            jobs.add(job)
        }

        jobs.joinAll()
        saveImage(inputImage, "F:\\output_grayscale.jpg")
        println("Image conversation finished.")
    }
}
