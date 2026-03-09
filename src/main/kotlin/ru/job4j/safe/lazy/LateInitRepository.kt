package ru.job4j.safe.lazy

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.util.*

class LateInitRepository {
    private lateinit var connection: Connection

    @SuppressWarnings("detekt:TooGenericExceptionCaught")
    fun init() {
        try {
            LateInitRepository::class.java.getClassLoader().getResourceAsStream("db.properties")
                .use { `in` ->
                    val config = Properties()
                    config.load(`in`)
                    Class.forName(config.getProperty("driver-class-name"))
                    connection = DriverManager.getConnection(
                        config.getProperty("url"),
                        config.getProperty("username"),
                        config.getProperty("password")
                    )
                }
        } catch (e: Exception) {
            throw IllegalStateException(e)
        }
    }

    fun exec(sql: String): String {
        try {
            connection.createStatement().execute(sql)
            return "Выполнен sql запрос: $sql"
        } catch (e: SQLException) {
            return "Ошибка в результате выполнения запроса: $sql -> ${e.message}"
        }
    }

}

fun main() {
val lateInitRepository = LateInitRepository()
    lateInitRepository.init()
    println(lateInitRepository.exec("select * from items"))
}
