package ru.job4j.oop.action

import ru.job4j.oop.Item
import ru.job4j.oop.Tracker
import ru.job4j.oop.input.Input

class AddItemAction: Action {
    override fun execute(tracker: Tracker, input: Input): Boolean {
        tracker.add(Item(0, input.ask("Введите пожалуйста имя заявки:")))
        return true
    }
}
