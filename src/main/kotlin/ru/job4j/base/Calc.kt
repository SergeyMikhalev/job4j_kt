package ru.job4j.base

fun add(first: Int, second: Int): Int {
    return first + second
}

fun subtract(first: Int, second: Int): Int {
    return first - second
}

fun multiply(first: Int, second: Int): Int {
    return first * second
}

fun divide(first: Int, second: Int): Int {
    return first / second
}

fun max(first: Int, second: Int): Int
= if (first > second) first else second

fun max(first:Int, second: Int, third: Int): Int
= max(max(first, second), third)


fun main() {

    val plus = add(5, 4)
    println("5 + 4 = $plus")

    val minus = subtract(7, 3)
    println("7 - 3 = $minus")

    val mul = multiply(7, 8)
    println("7 * 8 = $mul")

    val div = divide(6, 2)
    println("6 / 2 = $div")

    val maximum = max(7, 4)
    println("max from 7 and 4 is $maximum")

    val max3 = max(9, 11,2)
    println("max from 9, 11, 2 is $max3")

}