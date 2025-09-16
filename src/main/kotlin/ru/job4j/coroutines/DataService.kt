package ru.job4j.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.joinAll


@SuppressWarnings("detekt:MagicNumber")
class DataService {

    suspend fun fetchDataFromServer(id: Int): String {
        println("Fetching data for $id")
        delay(1000) // имитация запроса к серверу
        println("Data from server $id fetched")
        return "Data from server $id"
    }

    suspend fun saveDataToDatabase(data: String) {
        println("Saving $data")
        delay(1000) // имитация сохранения в базу данных
        println("$data saved")
    }
}

@SuppressWarnings("detekt:MagicNumber")
fun main() {
    val service = DataService() // Инициализация сервиса
    val jobs = mutableListOf<Job>()
    val scope = CoroutineScope(Dispatchers.IO)

    repeat(10) { id ->  // Запускаем 10 асинхронных задач
        jobs += scope.launch {
            val data = service.fetchDataFromServer(id)  // Получаем данные с сервера
            service.saveDataToDatabase(data)  // Сохраняем данные в базу
        }
    }

    runBlocking {
        jobs.joinAll()
    }

    println("Processing completed.")
}
