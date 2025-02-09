package ru.job4j.base

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat


class CalcTest {

    @Test
    fun addTest() {
        assertThat(add(1, 1)).isEqualTo(2)
    }

    @Test
    fun subTest() {
        assertThat(subtract(7,3)).isEqualTo(4)
    }

    @Test
    fun mulTest() {
        assertThat(multiply(2,5)).isEqualTo(10)
    }

    @Test
    fun divTest() {
        assertThat(divide(9,3)).isEqualTo(3)
    }
}