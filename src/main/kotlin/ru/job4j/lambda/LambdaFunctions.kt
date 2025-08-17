package ru.job4j.lambda

@Suppress("detekt:MagicNumber")
fun main() {
    val max = { x: Int, y: Int -> if (x > y) x else y }
    val decrement = { x: Int -> x-1 }
    val square = { x: Int -> x * x }

    val resultMax = max(1, 2)
    val resultDecrement = decrement(11)
    val resultSquare = square(5)

    println(resultMax)
    println(resultDecrement)
    println(resultSquare)
}
