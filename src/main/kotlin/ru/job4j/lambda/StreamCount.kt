package ru.job4j.lambda

import java.util.function.BinaryOperator

fun count(list: List<Int>) :Int {
    var acc = 0
    return list
        .stream()
        .filter {it > 9}
        .map { it + 1 }
        .reduce(Integer::sum)
        .orElse(0)
}

fun main() {
    val someList = arrayListOf(1,2,10,11)
    println(someList)
    println(count(someList))
}