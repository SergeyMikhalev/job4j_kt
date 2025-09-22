package ru.job4j.coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.io.File
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.stream.Collectors

fun main() {
    val logFile = File("F:\\1\\logs.txt")
    val logs = readLogs(logFile)
    val groupedLogs = groupLogsByDateAndLevel(logs)
    writeLogsToFiles(groupedLogs)
}

data class LogEntry(val date: String, val time: String, val level: String, val message: String)

@SuppressWarnings("detekt:MagicNumber")
fun readLogs(file: File): List<LogEntry> {
    val result = emptyList<LogEntry>().toMutableList()
    file.forEachLine {
        val logParts = it.split(" ", limit = 4)
        result += LogEntry(logParts[0], logParts[1], logParts[2], logParts[3])
    }
    return result.toList()
}

fun groupLogsByDateAndLevel(logs: List<LogEntry>): Map<String, Map<String, List<LogEntry>>> {
    return logs
        .stream()
        .collect(Collectors
            .groupingBy(LogEntry::level,
                Collectors.groupingBy { it.date }) )
}

fun writeLogsToFiles(groupedLogs: Map<String, Map<String, List<LogEntry>>>)  = runBlocking {
    groupedLogs
        .entries
        .asFlow()
        .collect{
            launch {
                val logFile = File("F:\\1\\${it.key}.txt")
                val sb = StringBuilder()
                if (!logFile.exists())  {
                    logFile.createNewFile()
                }
                it.value.entries.sortedBy { LocalDate.parse(it.key)  } .forEach { entry ->
                    sb.append("${entry.key}\n")
                    sb.append(entry.value.sortedBy { LocalTime.parse(it.time) }.joinToString(
                        separator = "\n",
                        postfix = "\n",
                        transform = {"${it.time} ${it.message}"}) )
                }
                logFile.writeText(sb.toString())
            }
        }
}
