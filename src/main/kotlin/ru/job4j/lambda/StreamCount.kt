package ru.job4j.lambda

@SuppressWarnings("detekt:MagicNumber")
fun count(list: List<Int>) :Int {
    return list
        .stream()
        .filter {it > 9}
        .map { it + 1 }
        .reduce(Integer::sum)
        .orElse(0)
}

@SuppressWarnings("detekt:MagicNumber")
fun main() {
    val someList = arrayListOf(1,2,10,11)
    println(someList)
    println(count(someList))
}
