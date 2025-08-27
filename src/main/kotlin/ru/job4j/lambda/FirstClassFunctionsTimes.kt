package ru.job4j.lambda

@SuppressWarnings("detekt:MagicNumber")
class FirstClassFunctionsTimes {
    private val add: (Int, Int) -> Int = { left, right -> left + right }

    fun times(left: (Int, Int) -> Int, right: (Int, Int) -> Int): (Int, Int, Int, Int) -> Int {
        return { a, b, c, d -> left(a, b) * right(c, d) }
    }

    fun test() {
        val order = times(add, add)
        val result = order(1, 2, 3, 4)
        println(result)
    }

}

fun main() {
    FirstClassFunctionsTimes().test()
}
