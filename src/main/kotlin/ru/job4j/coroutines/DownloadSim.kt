package ru.job4j.coroutines

import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay

private const val DELAY: Long = 500
private const val MAX_PERCENTAGE = 100

fun main(): Unit = runBlocking {
    launch {
        simulateLoading()
    }
}

suspend fun simulateLoading() {
    var loadingPercentage = 0
    while (loadingPercentage<= MAX_PERCENTAGE) {
        print("\rLoading... $loadingPercentage % ")
        loadingPercentage++
        delay(DELAY)
    }
    println()
    println("Loading finished")
}
