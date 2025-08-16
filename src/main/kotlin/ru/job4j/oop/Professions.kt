package ru.job4j.oop

open class Profession(val salary: Int = 0) {
    open fun getName():String = "Profession"

    open fun action() {
        println("action from " + getName())
    }
}

class Doctor(salary: Int, val speciality: String = "Therapist"): Profession(salary) {
    override fun getName(): String = "Doctor"

    override fun action() {
        super.action()
        println("Healing injures")
        println()
    }
}

@Suppress("detekt:UnusedPrivateProperty")
class Policeman(salary: Int, shoeSize:Int = 42): Profession(salary) {
    override fun getName(): String = "Policeman"

    override fun action() {
        super.action()
        println("Capturing bad boys")
        println()
    }
}

private const val ONE_THOUSAND = 1000

private const val TWO_THOUSAND = 2000

private const val FORTY_FOUR = 44

fun main(args: Array<String>) {
    Doctor(ONE_THOUSAND).action()
    Policeman(TWO_THOUSAND, FORTY_FOUR).action()
}
