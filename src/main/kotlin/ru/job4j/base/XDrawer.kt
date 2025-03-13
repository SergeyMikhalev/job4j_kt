package ru.job4j.base

fun draw(size :Int) {
    val center = size/2+1

    for (i in 1 .. size) {
        for (j in 1 .. size) {
            if ((i==center) && (j == center)) {
                print("X")
            } else if (i == j) {
                print("\\")
            } else if (j==size+1-i){
                print("/")
            } else {
                print(" ")
            }
        }
        println()
    }
}

fun main(args :Array<String>) {
    draw(5)
}