package ru.job4j.lambda

class HtmlTable {
    fun table(row: Int, cell: Int): String {
        val table = StringBuilder()
        table.apply {
            append("<table>\n")
            for (rows in 0 .. row) {
                append("<tr> ")
                for (cells in 0 .. cell) {
                    append("<td></td> ")
                }
                append("</tr>\n")
            }
            append("</table>\n")
        }
        return table.toString()
    }
}

fun main() {
    println(HtmlTable().table(3,3))
}