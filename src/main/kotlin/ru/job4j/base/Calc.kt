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


private const val FIVE = 5

private const val FOUR = 4

private const val SEVEN = 7

private const val THREE = 3

private const val EIGHT = 8

private const val SIX = 6

private const val TWO = 2

private const val NINE = 9

private const val ELEVEN = 11

fun main() {

    val plus = add(FIVE, FOUR)
    println("5 + 4 = $plus")

    val minus = subtract(SEVEN, THREE)
    println("7 - 3 = $minus")

    val mul = multiply(SEVEN, EIGHT)
    println("7 * 8 = $mul")

    val div = divide(SIX, TWO)
    println("6 / 2 = $div")

    val maximum = max(SEVEN, FOUR)
    println("max from 7 and 4 is $maximum")

    val max3 = max(NINE, ELEVEN, TWO)
    println("max from 9, 11, 2 is $max3")

}
