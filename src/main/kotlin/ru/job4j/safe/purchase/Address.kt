package ru.job4j.safe.purchase

data class Address(val street: String = "", val house: Int = 1, val zip: Int = 0) {
    override fun toString(): String {
        return "Address(street='$street', house=$house, zip=$zip)"
    }
}
