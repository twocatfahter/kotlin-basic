package 동기


fun grindBeans(beanType: String): String {
    Thread.sleep(1000)
    return "갈린 $beanType 원두"
}

fun brewCoffee(groundBeans: String): String {
    Thread.sleep(1000)
    return "${groundBeans}으로 만든 커피"
}

fun pourIntoCup(coffee: String): String {
    Thread.sleep(1000)
    return "[cup] $coffee"
}

//fun main() {
//    val startTime = System.currentTimeMillis()
//
//    // 순차적으로 실행
//    val ground = grindBeans("에티오피아")
//    val coffee = brewCoffee(ground)
//    val result = pourIntoCup(coffee)
//
//    println(result)
//    println("총 소요 시간: ${System.currentTimeMillis() - startTime}ms")
//}

fun main() {
    val orders = listOf("주문1", "주문2", "주문3")
    val start = System.currentTimeMillis()

    orders.forEach { order ->
        val ground = grindBeans(order)
        val coffee = brewCoffee(ground)
        val result = pourIntoCup(coffee)
        println("[$order] $result")
    }

    println("총 소요시간: ${System.currentTimeMillis() - start}ms")
}
