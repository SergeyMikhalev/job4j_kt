package ru.job4j.base

fun createArray(): Array<String?> {
    val names = arrayOfNulls<String>(10)
    names[0] = "Petr Arsentev"
    names[1] = "Petr Arsentev"
    names[4] = "Petr Arsentev"
    names[5] = "Petr Arsentev"
    names[7] = "Petr Arsentev"

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
    var emptyIdex = -1
    for ((index, str) in array.withIndex()) {
        if (str == null) {
            if (emptyIdex == -1 ) {
                emptyIdex = index
            }
        } else {
            if (emptyIdex !=-1) {
                array[emptyIdex] = str
                array[index] = null
                emptyIdex += 1
            }
        }
    }

}