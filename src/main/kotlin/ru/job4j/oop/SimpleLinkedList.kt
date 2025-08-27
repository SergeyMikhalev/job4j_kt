package ru.job4j.oop

import java.util.NoSuchElementException

class SimpleLinkedList<T> : Iterable<T> {
    private var head : Node<T>? = null

    fun add(value: T) {
        head = Node<T>(value, head)
    }

    override fun iterator(): Iterator<T> {
        return LinkedIt()
    }

    inner class LinkedIt : Iterator<T> {
        private var currentElement = head

        override fun hasNext(): Boolean {
            return currentElement != null
        }

        override fun next(): T {
            if (!hasNext()) {
                throw NoSuchElementException()
            }
            val result = currentElement!!.value
            currentElement = currentElement!!.next
            return result
        }

    }

    class Node<K>(val value: K, var next: Node<K>? = null)
}

fun main() {
    val list = SimpleLinkedList<String>()

    list.add("Kotlin")
    list.add("C#")
    list.add("Java")

    for (value in list) {
        println(value)
    }
}
