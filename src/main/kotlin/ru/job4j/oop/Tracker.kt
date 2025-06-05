package ru.job4j.oop


class Tracker {
    private var id = 0
    private val items = arrayListOf<Item>()

    fun add(item: Item): Item {
        item.id = id++
        items.add(item)
        return item
    }

    fun findAll(): List<Item> = items

    fun findById(id: Int): Item? {
        val index = indexOf(id)
        if (index == -1) {
            return null
        }
        return items[index]
    }

    fun findByName(key: String): List<Item> {
        val result = mutableListOf<Item>()
        items.stream()
            .filter { key == it.name }
            .forEach(result::add)
        return result
    }

    fun replace(id: Int, item: Item): Boolean {
        val index = indexOf(id)
        if (index == -1) {
            return false
        }
        item.id = id
        items[index] = item
        return true
    }

    fun delete(id: Int): Boolean {
        val index = indexOf(id)
        if (index == -1) {
            return false
        }
        items.removeAt(index)
        return true
    }

    private fun indexOf(id: Int): Int {
        for ((index, item) in items.withIndex()) {
            if (item.id == id) {
                return index
            }
        }

        return -1
    }

}
