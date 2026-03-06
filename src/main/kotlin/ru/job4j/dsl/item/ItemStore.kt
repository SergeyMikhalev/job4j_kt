package ru.job4j.dsl.item

import ru.job4j.oop.Item
import ru.job4j.oop.Tracker

internal object ItemStore: Store<Item> {
    private val tracker = Tracker()

    override fun save(model: Item): Item {
        println("Saving item using our singleton ItemStore")
        println("Object saved in tracker class instance")
        return tracker.add(model)
    }

}
