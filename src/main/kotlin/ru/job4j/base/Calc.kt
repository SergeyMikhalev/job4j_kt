package ru.job4j.base

fun add(first: Int, second :Int) :Int {
    return first + second
}

fun subtract(first: Int, second :Int) :Int {
    return first - second
}

fun multiply(first: Int, second :Int) :Int {
    return first * second
}

fun divide(first: Int, second :Int) :Int {
    return first / second
}

fun main() {

    val plus = add(5, 4)
    println("5 + 4 = $plus")

    val minus = subtract(7, 3)
    println("7 - 3 = $minus")

    val mul = multiply(7, 8)
    println("7 * 8 = $mul")

    val div = divide(6, 2)
    println("6 / 2 = $div")

}