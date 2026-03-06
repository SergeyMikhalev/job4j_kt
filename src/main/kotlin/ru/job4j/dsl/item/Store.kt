package ru.job4j.dsl.item

interface Store<T> {
    fun save(model: T): T
}
