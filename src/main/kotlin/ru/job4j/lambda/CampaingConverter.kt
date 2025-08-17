package ru.job4j.lambda

import java.time.LocalDate

fun convert(companies :List<Company>) :List<String> = companies.map {
"""
-----
Company info
-----
Name : ${it.name} 
Address :  ${it.address.street} -  ${it.address.building} - ${it.address.office}
Created : ${it.created}
-----
"""
}

fun main() {
    val company = Company("Sber", Address("Lenina", "11a", "67"), LocalDate.now())
    val companies = arrayListOf(company)

    println(companies)
    println(convert(companies))
}
