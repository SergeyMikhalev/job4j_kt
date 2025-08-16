package ru.job4j.oop.action

import ru.job4j.oop.Tracker
import ru.job4j.oop.input.Input

class ExitApplicationAction: Action {
    override fun execute(tracker: Tracker, input: Input): Boolean {
        println("Завершение работы!")
        return false
    }
}
