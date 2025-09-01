package ru.job4j.safe.finance

import java.time.LocalDate
import java.util.Objects


data class Stock(val name: String, val currency: Currency, val date: LocalDate) {

    override fun hashCode(): Int {
        return Objects.hash(name, currency, date)
    }

    override fun equals(other: Any?): Boolean {
        if (javaClass!=other?.javaClass) return false
        other as Stock

        return (other.name == name)
                && (other.date == date)
                && (other.currency == currency)
    }
}

fun main() {
    val ruble = Currency(34, "Рубль")
    val dollar = Currency(10, "Дллар США")

    val msft = Stock("Майкрософт", dollar, LocalDate.now())
    val sbmx = Stock("Сбер", ruble, LocalDate.now())

    println(msft.equals(sbmx))
    println(sbmx.equals(sbmx))

}