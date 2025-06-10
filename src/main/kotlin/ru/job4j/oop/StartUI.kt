package ru.job4j.oop

class StartUI {

    companion object {
        
        private const val OPERATIONS_DESCRIPTION = """
                ----------------------------------
                Доступные операции:
                1 - Добавить заявку
                2 - Вывести список заявок 
                3 - Выход
                Пожалуйста, введите номер операции:
            """

        fun printAllItems(tracker: Tracker) {
            println("Список сохраненных заявок:")
            tracker.findAll().forEach { println("" + it.id + " - " + it.name) }
        }

        fun addItem(tracker: Tracker) {
            println("Введите пожалуйста имя заявки:")
            tracker.add(Item(0, readln()))
        }
    }

    private val tracker = Tracker()

    fun init() {
        var run = true
        var operation =""
        while (run) {
            println(OPERATIONS_DESCRIPTION.trimIndent())
            operation = readln()

            when (operation) {
                "1" -> addItem(tracker)
                "2" -> printAllItems(tracker)
                "3" -> {
                    println("Завершение работы!")
                    run = false
                }
                else -> println("Неверный ввод. Повсторите попытку.")
            }
        }
    }
}

fun main(args: Array<String>) {
    StartUI().init()
}
