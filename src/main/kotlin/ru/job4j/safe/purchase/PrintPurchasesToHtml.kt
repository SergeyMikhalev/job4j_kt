package ru.job4j.safe.purchase

import java.time.LocalDate

fun toHtmlTable(purchases :ArrayList<Purchase>) :String {
    return buildString {
        append("<table>\n")

        for (purchase in purchases) {
            append("<tr>\n")

            append("<td>")
            append(purchase.name)
            append("</td>\n")

            append("<td>")
            append(purchase.created)
            append("</td>\n")

            append("<td>")
            append(purchase.address?.toString() ?: "   ")
            append("</td>\n")

            append("</tr>\n")
        }
        append("</table>\n")
    }
}

@SuppressWarnings("detekt:MagicNumber")
fun main() {
    val purchases = arrayListOf(
        Purchase("Колонка", LocalDate.now(), Address("Ленина", 11, 22)),
        Purchase("Хлеборезка", LocalDate.now(), null)
        )

    println(toHtmlTable(purchases))
}
