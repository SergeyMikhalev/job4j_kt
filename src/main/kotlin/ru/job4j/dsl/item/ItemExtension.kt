package ru.job4j.dsl.item

import ru.job4j.oop.Item

fun Item.save():Item = ItemStore.save(this)
