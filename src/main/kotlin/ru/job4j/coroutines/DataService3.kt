package ru.job4j.coroutines

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.launch
import kotlin.coroutines.cancellation.CancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking


class DataService3 {

    @SuppressWarnings("detekt:MagicNumber")
    suspend fun performOperation(timeout: Long) = coroutineScope {

        val usefulJob = launch {
            try {
                for (i in 1..3) {
                    ensureActive()
                    val duration = 1000 * (1..3).random().toLong()
                    println("Корутина 1: Делаю полезную работу. Часть $i. Время выполнения: $duration мс.")
                    delay(duration)
                }
                println("Корутина 1: Всё сделал")
            } catch (e :CancellationException) {
                println("Корутина 1: Корутина прервана извне")
                throw e
            }

        }

        launch {
            delay(timeout)
            if (usefulJob.isActive) {
                println("Корутина 2: Превышен лимит времени выполнения полезной работы. Отмена корутины.")
                usefulJob.cancel()
            }
        }

        usefulJob.join()
    }

}

@SuppressWarnings("detekt:MagicNumber")
fun main() = runBlocking {
    val dataService = DataService3()
    dataService.performOperation(5000)
}
