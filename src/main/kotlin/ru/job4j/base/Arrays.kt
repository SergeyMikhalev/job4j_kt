package ru.job4j.base


private const val SIZE = 10

private const val ZERO = 0

private const val ONE = 1

private const val FOUR = 4

private const val FIVE = 5

private const val SEVEN = 7

fun createArray(): Array<String?> {
    val names = arrayOfNulls<String>(SIZE)
    names[ZERO] = "Petr Arsentev"
    names[ONE] = "Petr Arsentev"
    names[FOUR] = "Petr Arsentev"
    names[FIVE] = "Petr Arsentev"
    names[SEVEN] = "Petr Arsentev"

    names.forEach { s -> println(s) }

    return names
}

fun main() {
    val names = createArray()
    defragment(names)
    println("--")
    names.forEach { s -> println(s) }
}

fun defragment(array: Array<String?>) {
    var emptyIdex = -ONE
    for ((index, str) in array.withIndex()) {
        if (str == null) {
            if (emptyIdex == -ONE) {
                emptyIdex = index
            }
        } else {
            if (emptyIdex !=-ONE) {
                array[emptyIdex] = str
                array[index] = null
                emptyIdex += ONE
            }
        }
    }

}
