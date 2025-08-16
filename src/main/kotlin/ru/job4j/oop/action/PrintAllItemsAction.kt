package ru.job4j.oop.action

import ru.job4j.oop.Tracker
import ru.job4j.oop.input.Input

class PrintAllItemsAction: Action {
    override fun execute(tracker: Tracker, input: Input): Boolean {
        println("Список сохраненных заявок:")
        tracker.findAll().forEach { println("" + it.id + " - " + it.name) }
        return true
    }
}
