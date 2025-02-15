package ru.job4j.base

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ArraysTest {

    @Test
    fun whenRotatesNullsAndValues() {
        // arrange
        val data = arrayOf("1", "2", null, null, "3", null, "4")
        val expected = arrayOf("1", "2", "3", "4", null, null, null)

        //act
        defragment(data)

        // assert
        assertArrayEquals(expected, data)
    }

    @Test
    fun whenAllNonNullAtTheEnd() {
        // arrange
        val data = arrayOf(null, null, null, "1", "2")
        val expected = arrayOf("1", "2", null, null, null)

        //act
        defragment(data)

        // assert
        assertArrayEquals(expected, data)
    }

    @Test
    fun whenOnlyNonNulls() {
        // arrange
        val data: Array<String?> = arrayOf("1", "2", "3")
        val expected = arrayOf("1", "2", "3")

        //act
        defragment(data)

        // assert
        assertArrayEquals(expected, data)
    }

    @Test
    fun whenOnlyNulls() {
        // arrange
        val data: Array<String?> = arrayOf(null, null, null)
        val expected: Array<String?> = arrayOf(null, null, null)

        //act
        defragment(data)

        // assert
        assertArrayEquals(expected, data)
    }

    @Test
    fun whenOnlyOneNull() {
        // arrange
        val data: Array<String?> = arrayOf(null)
        val expected: Array<String?> = arrayOf(null)

        //act
        defragment(data)

        // assert
        assertArrayEquals(expected, data)
    }

    @Test
    fun whenOnlyOneNonNull() {
        // arrange
        val data: Array<String?> = arrayOf("1")
        val expected: Array<String?> = arrayOf("1")

        //act
        defragment(data)

        // assert
        assertArrayEquals(expected, data)
    }

    @Test
    fun whenEmpty() {
        // arrange
        val data: Array<String?> = arrayOf()
        val expected: Array<String?> = arrayOf()

        //act
        defragment(data)

        // assert
        assertArrayEquals(expected, data)
    }


}