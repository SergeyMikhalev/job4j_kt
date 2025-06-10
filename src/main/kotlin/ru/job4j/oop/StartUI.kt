package ru.job4j.oop

object StartUI {
    private const val OPERATIONS_DESCRIPTION = """
                ----------------------------------
                Доступные операции:
                1 - Добавить заявку
                2 - Вывести список заявок 
                3 - Выход
                Пожалуйста, введите номер операции:
            """

    private val tracker = Tracker()

    fun init() {
        var run = true
        var operation =""
        while (run) {
            println(OPERATIONS_DESCRIPTION.trimIndent())
            operation = readln()

            when (operation) {
                "1" -> addItem()
                "2" -> printAllItems()
                "3" -> {
                    println("Завершение работы!")
                    run = false
                }
                else -> println("Неверный ввод. Повсторите попытку.")
            }
        }
    }

    private fun printAllItems() {
        println("Список сохраненных заявок:")
        tracker.findAll().forEach { println("" + it.id + " - " + it.name) }
    }

    private fun addItem() {
        println("Введите пожалуйста имя заявки:")
        tracker.add(Item(0, readln()))
    }

}

fun main(args: Array<String>) {
    StartUI.init()
}
