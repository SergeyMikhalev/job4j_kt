package ru.job4j.coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.launch

class DataService3 {

    suspend fun performOperation(timeout: Long) {

        val job = launch {
            println("Повышаем престиж профессии учителя")
            delay()

        }
        // Создайте первую корутину для выполнения полезной функции (job)
        // В этой корутине используйте цикл и delay для имитации работы
        // Добавьте логику для обработки отмены через try-catch или isActive

        // Создайте вторую корутину для отслеживания времени и отмены первой корутины
        // Используйте delay для имитации тайм-аута
        // Если тайм-аут достигнут, отмените первую корутину

        // Ожидайте завершения первой корутины с помощью job.join()
    }
}

fun main() = runBlocking {
    val dataService = DataService3()
    dataService.performOperation(1000)
}