package ru.job4j.dsl.other

import ru.job4j.dsl.item.save
import ru.job4j.oop.Item

fun main() {
    val newItem = Item(name = "Valera", id = 100 )
    println(newItem.save())
}
