package ru.job4j.dsl

data class Sale(
    val productName: String,
    val category: String,
    val quantitySold: Int,
    val totalRevenue: Double
)

// Фильтрация по категории
inline fun filterByCategory(sales: List<Sale>, category: String): List<Sale>
    =  sales.filter { it.category == category }

// Расчет общей выручки
inline fun calculateTotalRevenue(sales: List<Sale>): Double
   = sales.sumOf { it.totalRevenue }


// Поиск самых продаваемых продуктов
inline fun topSellingProducts(sales: List<Sale>, topN: Int): List<Sale>
    = sales.sortedByDescending { it.quantitySold }.take(topN)


// Фильтрация по минимальной выручке
inline fun filterByMinRevenue(sales: List<Sale>, minRevenue: Double): List<Sale>
    = sales.filter { it.totalRevenue > minRevenue }


// Пример комбинированной операции: фильтрация по категории -> топ-продукты -> общая выручка
fun combinedSalesAnalysis(sales: List<Sale>, category: String, topN: Int): Double
    = calculateTotalRevenue(topSellingProducts(filterByCategory(sales, category), topN))

@SuppressWarnings("detekt:MagicNumber")
fun main() {
    val sales = listOf(
        Sale("Laptop", "Electronics", 10, 5000.0),
        Sale("Smartphone", "Electronics", 20, 3000.0),
        Sale("Tablet", "Electronics", 15, 2000.0),
        Sale("Headphones", "Accessories", 50, 1500.0),
        Sale("Charger", "Accessories", 100, 1000.0)
    )

    // Пример: Фильтрация по категории, нахождение топ-2 продукта и подсчет их выручки
    val electronicsRevenue = combinedSalesAnalysis(sales, "Electronics", 2)
    println("Общая выручка от топ-2 продуктов категории 'Electronics': $electronicsRevenue")

}
