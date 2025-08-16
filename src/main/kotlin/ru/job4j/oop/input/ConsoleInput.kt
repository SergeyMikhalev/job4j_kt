package ru.job4j.oop.input

class ConsoleInput: Input {
    override fun ask(question: String): String {
        println(question)
        return readln()
    }
}
