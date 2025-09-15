package ru.job4j.oop


import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class AnotherLinkedListTest {

    /*
    * Тесты на пустой список
    * */

    @Test
    fun whenEmptyListHasNextThenFalse() {
        val list = AnotherLinkedList<String>()
        assertFalse(list.hasNext())
    }

    @Test
    fun whenEmptyListHasPreviousThenFalse() {
        val list = AnotherLinkedList<String>()
        assertFalse(list.hasPrevious())
    }

    @Test
    fun whenEmptyListNextIndexThenZero() {
        val list = AnotherLinkedList<String>()
        assertEquals(0, list.nextIndex())
    }

    @Test
    fun whenEmptyListPreviousIndexThenMinusOne() {
        val list = AnotherLinkedList<String>()
        assertEquals(-1, list.previousIndex())
    }

    @Test
    fun whenEmptyListNextThenException() {
        val list = AnotherLinkedList<String>()
        assertThrows<NoSuchElementException> { list.next() }
    }

    @Test
    fun whenEmptyListPreviousThenException() {
        val list = AnotherLinkedList<String>()
        assertThrows<NoSuchElementException> { list.previous() }
    }

    /*
    * Тесты работу в начале списка из 3х элементов
    * */

    @Test
    fun when3ElementListBeginningHasNextThenTrue() {
        val list = get3ElementListAtBeginning()
        assertTrue(list.hasNext())
    }

    @Test
    fun when3ElementListBeginningHasPreviousThenFalse() {
        val list = get3ElementListAtBeginning()
        assertFalse(list.hasPrevious())
    }

    @Test
    fun when3ElementListBeginningNextIndexThenOne() {
        val list = get3ElementListAtBeginning()
        assertEquals(0, list.nextIndex())
    }

    @Test
    fun when3ElementListBeginningPreviousIndexThenMinusOne() {
        val list = get3ElementListAtBeginning()
        assertEquals(-1, list.previousIndex())
    }

    @Test
    fun when3ElementListBeginningNextThenFirstElement() {
        val list = get3ElementListAtBeginning()
        assertEquals("1", list.next())
    }

    @Test
    fun when3ElementListBeginningPreviousIndexThenException() {
        val list = get3ElementListAtBeginning()
        assertThrows<NoSuchElementException> { list.previous() }
    }

    /*
    * Тесты работу в середине списка из 3х элементов
    * */

    @Test
    fun when3ElementListMiddleHasNextThenTrue() {
        val list = get3ElementListAtMiddle()
        assertTrue(list.hasNext())
    }

    @Test
    fun when3ElementListMiddleHasPreviousThenTrue() {
        val list = get3ElementListAtMiddle()
        assertTrue(list.hasPrevious())
    }

    @Test
    fun when3ElementListMiddleNextIndexThenTwo() {
        val list = get3ElementListAtMiddle()
        assertEquals(2, list.nextIndex())
    }

    @Test
    fun when3ElementListMiddlePreviousIndexThenOne() {
        val list = get3ElementListAtMiddle()
        assertEquals(1, list.previousIndex())
    }

    @Test
    fun when3ElementListMiddleNextThenSecondElement() {
        val list = get3ElementListAtMiddle()
        assertEquals("3", list.next())
    }

    @Test
    fun when3ElementListMiddlePreviousThenSecondElement() {
        val list = get3ElementListAtMiddle()
        assertEquals("2", list.previous())
    }

    /*
    * Тесты работу в конце списка из 3х элементов
    * */

    @Test
    fun when3ElementListEndHasNextThenFalse() {
        val list = get3ElementListAtEnd()
        assertFalse(list.hasNext())
    }

    @Test
    fun when3ElementListEndHasPreviousThenTrue() {
        val list = get3ElementListAtEnd()
        assertTrue(list.hasPrevious())
    }

    @Test
    fun when3ElementListEndNextIndexThenThree() {
        val list = get3ElementListAtEnd()
        assertEquals(3, list.nextIndex())
    }

    @Test
    fun when3ElementListEndPreviousIndexThenTwo() {
        val list = get3ElementListAtEnd()
        assertEquals(2, list.previousIndex())
    }

    @Test
    fun when3ElementListEndNextThenException() {
        val list = get3ElementListAtEnd()
        assertThrows<NoSuchElementException> { list.next() }
    }

    @Test
    fun when3ElementListEndPreviousThenThirdElement() {
        val list = get3ElementListAtEnd()
        assertEquals("3", list.previous())
    }

    /*
    * Функции помошники
    * */

    private fun get3ElementListAtBeginning(): AnotherLinkedList<String> {
        val list = AnotherLinkedList<String>()
        list.add("3")
        list.add("2")
        list.add("1")
        return list
    }

    private fun get3ElementListAtMiddle(): AnotherLinkedList<String> {
        val list = get3ElementListAtBeginning()
        list.next()
        list.next()
        return list
    }

    private fun get3ElementListAtEnd(): AnotherLinkedList<String> {
        val list = get3ElementListAtBeginning()
        list.next()
        list.next()
        list.next()
        return list
    }

}
