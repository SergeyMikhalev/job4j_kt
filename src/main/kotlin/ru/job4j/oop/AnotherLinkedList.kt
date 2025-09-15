package ru.job4j.oop

import java.util.NoSuchElementException

class AnotherLinkedList<T> : Iterable<T>, ListIterator<T> {
    private var head : Node<T>? = null
    private var current : Node<T>? = null
    private var position = 0

    fun add(value: T) {
        head = Node<T>(value, head)
        current = head
        position = 0
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

    override fun hasNext(): Boolean {
        return current!=null
    }

    override fun hasPrevious(): Boolean {
        return (head != null)  && (position > 0)
    }

    override fun next(): T {
        if (!hasNext()) {
            throw NoSuchElementException()
        }
        val result = current!!.value
        current = current!!.next
        position++
        return result
    }

    override fun nextIndex(): Int {
        return position
    }

    override fun previous(): T {
        if (!hasPrevious()) {
            throw NoSuchElementException()
        }
        var point = head
        var i =0
        while (i < position-1) {
            point = point!!.next
            i++
        }
        current = point
        position--
        return current!!.value

    }

    override fun previousIndex(): Int {
        return position-1
    }
}

fun main() {
    val list = AnotherLinkedList<String>()

    list.add("Вася")
    list.add("Петя")
    list.add("Коля")
    for (value in list) {
        println(value)
    }

}
