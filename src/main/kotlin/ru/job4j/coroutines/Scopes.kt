package ru.job4j.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.delay

@SuppressWarnings("detekt:MagicNumber")
fun main() = runBlocking {

    println("Функция main вызвана в потоке :  ${Thread.currentThread().name}")
    println("Запуск корутин!")

    // Запуск первой корутины с Dispatchers.IO
    val job1 = CoroutineScope(Dispatchers.IO).launch {
        println("Корутина диспетчера Dispatchers.IO. Запущена в потоке: ${Thread.currentThread().name}")
        delay(4000)
        println("Корутина диспетчера Dispatchers.IO. Завершена в потоке: ${Thread.currentThread().name}")
    }

    // Запуск второй корутины с Dispatchers.Default
    val job2 = CoroutineScope(Dispatchers.Default).launch {
        println("Корутина диспетчера Dispatchers.Default. Запущена в потоке: ${Thread.currentThread().name}")
        delay(3000)
        println("Корутина диспетчера Dispatchers.Default. Завершена в потоке: ${Thread.currentThread().name}")
    }

    // Запуск третьей корутины с Dispatchers.Unconfined
    val job3 = CoroutineScope(Dispatchers.Unconfined).launch {
        println("Корутина диспетчера Dispatchers.Unconfined. Запущена в потоке: ${Thread.currentThread().name}")
        delay(2000)
        println("Корутина диспетчера Dispatchers.Unconfined. Завершена в потоке: ${Thread.currentThread().name}")
    }

    println("Ожидание завершения задач....")

    job1.join()
    job2.join()
    job3.join()

    println("Все задачи завершены")
}
