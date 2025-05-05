package ru.job4j.oop

class Tracker {
    private var id:Int = 0;
    private val items: ArrayList<Item> = ArrayList();

    fun add(item: Item) :Item {
        item.setId(id++)
        items.add(item)
        return item
    }

    fun findAll() :List<Item> = items

    fun findById(id: Int) : Item? {
        val index = indexOf(id)
        return if (index != -1) items[index] else null
    }

    fun findByName(key: String): List<Item> {
        val result: ArrayList<Item> = ArrayList()
        for (item in items) {
            if (key == item.getName()) {
                result.add(item)
            }
        }
        return result
    }

    fun replace(id: Int, item: Item): Boolean {
        val index = indexOf(id)
        if (index == -1) {
            return false
        }
        item.setId(id)
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

    private fun indexOf(id :Int): Int {
        for((index, item) in items.withIndex()) {
            if (item.getId() == id) {
                return  index
            }
        }

        return -1
    }

}
