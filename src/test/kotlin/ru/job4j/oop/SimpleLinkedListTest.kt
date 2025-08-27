package ru.job4j.oop

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import java.util.NoSuchElementException

class SimpleLinkedListTest {

    @Test
    fun whenEmptyListIterator() {
        val list = SimpleLinkedList<String>()

        val iterator = list.iterator()

        assertFalse(iterator.hasNext())
        assertThrows(NoSuchElementException::class.java) {
            iterator.next()
        }
    }

    @Test
    fun whenMultipleElementsInListIterator() {
        val list = SimpleLinkedList<String>()

        list.add("Kotlin")
        list.add("Java")

        val iterator = list.iterator()

        assertTrue(iterator.hasNext())
        assertEquals("Java", iterator.next())

        assertTrue(iterator.hasNext())
        assertEquals("Kotlin", iterator.next())

        assertFalse(iterator.hasNext())
        assertThrows(NoSuchElementException::class.java) {
            iterator.next()
        }
    }
}
