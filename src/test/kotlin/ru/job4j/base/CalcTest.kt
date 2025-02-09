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

    @Test
    fun max2AndFirstGreater() {
        assertThat(max(66,11)).isEqualTo(66)
    }

    @Test
    fun max2AndSecondGreater() {
        assertThat(max(9,14)).isEqualTo(14)
    }

    @Test
    fun max3AndFirstGreater() {
        assertThat(max(7,1,4)).isEqualTo(7)
    }

    @Test
    fun max3AndSecondGreater() {
        assertThat(max(66,111,0)).isEqualTo(111)
    }

    @Test
    fun max3AndThirdGreater() {
        assertThat(max(-33,5,10)).isEqualTo(10)
    }

}