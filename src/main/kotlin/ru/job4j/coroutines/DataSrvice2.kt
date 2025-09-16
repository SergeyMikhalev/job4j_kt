package ru.job4j.coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking


data class UserInfoDTO(
    val userData: String,
    val userPreferences: String,
    val userHistory: String
)

@SuppressWarnings("detekt:MagicNumber")
class DataService {

    // Метод для получения основной информации о пользователе
    suspend fun fetchUserData(userId: Int): String {
        println("Fetching user data for $userId")
        delay(1000) // имитация запроса к серверу
        return "User data for $userId"
    }

    // Метод для получения предпочтений пользователя
    suspend fun fetchUserPreferences(userId: Int): String {
        println("Fetching user preferences for $userId")
        delay(1000) // имитация запроса к серверу
        return "User preferences for $userId"
    }

    // Метод для получения истории действий пользователя
    suspend fun fetchUserHistory(userId: Int): String {
        println("Fetching user history for $userId")
        delay(1000) // имитация запроса к серверу
        return "User history for $userId"
    }

    // Метод для параллельного сбора всех данных и создания DTO модели
    suspend fun fetchUserInfo(userId: Int): UserInfoDTO = coroutineScope {
        val deferredUserData  = async { fetchUserData(userId) }
        val deferredUserPreferences  = async { fetchUserPreferences(userId) }
        val deferredUserHistory  = async { fetchUserHistory(userId) }

        val result = awaitAll(deferredUserData, deferredUserPreferences, deferredUserHistory)

        return@coroutineScope UserInfoDTO(result[0],result[1],result[2])
    }
}

@SuppressWarnings("detekt:MagicNumber")
fun main() = runBlocking {
    val service = DataService()

    // Получаем информацию для пользователя с ID 1
    val userInfo = service.fetchUserInfo(1)

    println("UserInfoDTO: $userInfo")
}
