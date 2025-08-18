package ru.job4j.oop

import ru.job4j.oop.action.AddItemAction
import ru.job4j.oop.action.ExitApplicationAction
import ru.job4j.oop.action.PrintAllItemsAction
import ru.job4j.oop.input.ConsoleInput

private const val OPERATIONS = """
                        ----------------------------------
                        Доступные операции:
                        1 - Добавить заявку
                        2 - Вывести список заявок 
                        3 - Выход
                        Пожалуйста, введите номер операции:
                    """

class StartUI {

    private val tracker = Tracker()
    private val input = ConsoleInput()

    private val addItemAction = AddItemAction()
    private val printAllItemsAction = PrintAllItemsAction()
    private val exitApplicationAction = ExitApplicationAction()

    fun init() {
        var run = true
        var operation =""
        while (run) {
            println(
                OPERATIONS.trimIndent()
            )
            operation = readln()

            when (operation) {
                "1" -> run = addItemAction.execute(tracker, input)
                "2" -> run = printAllItemsAction.execute(tracker, input)
                "3" -> run = exitApplicationAction.execute(tracker, input)
                else -> println("Неверный ввод. Повсторите попытку.")
            }
        }
    }
}

fun main(args: Array<String>) {
    StartUI().init()
}
