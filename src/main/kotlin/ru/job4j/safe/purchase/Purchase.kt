package ru.job4j.safe.purchase

import java.time.LocalDate

data class Purchase(val name :String, val created: LocalDate, val address :Address?)
