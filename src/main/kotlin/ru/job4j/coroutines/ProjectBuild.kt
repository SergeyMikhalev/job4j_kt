package ru.job4j.coroutines

import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ClosedReceiveChannelException
import kotlinx.coroutines.channels.ClosedSendChannelException

const val RECEIVER_COROUTINES_COUNT = 4
const val CHANNEL_CAPACITY = 4
const val GENERATED_EVENTS_COUNT = 10
const val ONE_SECOND = 1000L

data class Event(val id: Int)

class ProjectBuild {

    private val eventChannel = Channel<Event>(CHANNEL_CAPACITY)
    private val receivers = mutableListOf<Job>()

    fun closeChannel(): Boolean = eventChannel.close()

    @SuppressWarnings("detekt:SwallowedException")
    suspend fun addEvent(event: Event) {
        try {
            eventChannel.send(event)
            println("Производителем добавлена задача ${event.id}")
        } catch (e: ClosedSendChannelException) {
            println("Добавление событий в канал более не возможно, т.к. он закрыт.")
        }
    }

    fun start() {
        for (i in 1..RECEIVER_COROUTINES_COUNT) {
            receivers += CoroutineScope(Dispatchers.Default).launch {
                runEventReceiver(i)
            }
        }
    }

    @SuppressWarnings("detekt:SwallowedException")
    private suspend fun runEventReceiver(receiverId: Int) {
        println("--Обработчик событий $receiverId запущен.")
        try {
            for (event in eventChannel) {
                println("--Обработчик $receiverId : обрабатываю событие ${event.id}")
                delay(ONE_SECOND)
                println("--Обработчик $receiverId : завершил обработку события ${event.id}")
            }
            println("--Обработчик $receiverId : Все события в канале обработаны.")
        } catch (e: ClosedReceiveChannelException) {
            println("--Обработчик $receiverId : Обработка событий из канал более не возможна, т.к. он закрыт.")
        } finally {
            println("--Обработчик событий $receiverId завершает свою работу.")
        }
    }

    suspend fun joinAll() = receivers.joinAll()

}


fun main() {
    runBlocking {
        val build = ProjectBuild()
        build.start()
        println("Производитель генерирует события.")
        launch {
            for (j in 1..GENERATED_EVENTS_COUNT) {
                build.addEvent(Event(j))
            }
            println("Производитель закрывает канал.")
            build.closeChannel()
            build.joinAll()
        }
    }
}
