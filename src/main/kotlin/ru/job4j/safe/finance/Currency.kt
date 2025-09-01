package ru.job4j.safe.finance

data class Currency(val code :Int, val name :String) {
    override fun equals(other: Any?): Boolean {
        if ((null == other ) ||
                (javaClass != other.javaClass))
        return false

        other as Currency

        return code == other.code
    }

    override fun hashCode(): Int {
        return code
    }
}
