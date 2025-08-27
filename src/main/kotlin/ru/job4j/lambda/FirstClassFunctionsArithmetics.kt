package ru.job4j.lambda

fun operation(type: String): (Double, Double) -> Double {
    val result = when (type) {
        "add" -> { left: Double, right: Double -> left + right }
        "subtract" -> { left, right -> left - right }
        "multiply" -> { left, right -> left * right }
        "divide" -> { left, right -> left / right }
        else -> { left, right -> Double.NaN }
    }
    return result
}

@SuppressWarnings("detekt:MagicNumber")
fun main() {
    val add = operation("add")
    println(add(5.0, 3.0)) // 8.0

    val subtract = operation("subtract")
    println(subtract(5.0, 3.0)) // 2.0

    val multiply = operation("multiply")
    println(multiply(5.0, 3.0)) // 15.0

    val divide = operation("divide")
    println(divide(5.0, 3.0)) // 1.6666...

    val unknown = operation("mod")
    println(unknown(5.0, 3.0)) // NaN
}
