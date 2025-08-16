package ru.job4j.oop.action

import ru.job4j.oop.Tracker
import ru.job4j.oop.input.Input

interface Action {
    fun execute(tracker: Tracker, input: Input): Boolean
}
