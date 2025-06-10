package ru.job4j.oop

open class Profession(val salary: Int = 0)

class Doctor(salary: Int, val speciality: String = "Therapist"): Profession(salary)

@Suppress("detekt:UnusedPrivateProperty")
class Policeman(salary: Int, shoeSize:Int = 42): Profession(salary)

private const val ONE_THOUSAND = 1000

private const val TWO_THOUSAND = 2000

private const val FORTY_FOUR = 44

fun main(args: Array<String>) {
    println(Doctor(ONE_THOUSAND))
    println(Policeman(TWO_THOUSAND, FORTY_FOUR))
}
