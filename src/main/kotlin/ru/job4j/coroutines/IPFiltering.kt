package ru.job4j.coroutines

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import java.util.concurrent.ConcurrentHashMap
import kotlin.time.Duration
import kotlin.time.Duration.Companion.minutes

val requestCount = ConcurrentHashMap<String, Long>()

suspend fun handleRequest(ip: String) {

}

// Coroutine для периодического сброса счетчиков запросов
fun startResetJob() {
//!!!!
}

// Пример использования
fun main() {
    runBlocking {
        startResetJob()
        repeat(150) { index ->
            launch {
                handleRequest("192.168.1.1")
            }
        }
    }
}