package ru.job4j.dsl

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.assertj.core.api.Assertions.assertThat

infix fun Any.eq(expected: Any) {
    assertEquals(expected, this)
}

infix fun Any.notEq(expected: Any) {
    assertNotEquals(expected, this)
}

infix fun <T> Collection<T>.contains(expected: T) {
    assertThat(this).contains(expected)
}

fun main() {
    val value = 1
    value eq 1
    value notEq 2

    val someList = listOf("Vasia", "Petia", "Kolya")
    someList contains "Kolya"
}

