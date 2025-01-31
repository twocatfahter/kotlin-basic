package 코루틴

import kotlinx.coroutines.*
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import kotlin.coroutines.Continuation
import kotlin.system.measureTimeMillis

val dispatcher = Executors.newFixedThreadPool(3).asCoroutineDispatcher()

suspend fun grindBeans(beanType: String): String {
    delay(1000)
    return "갈린 $beanType 원두"
}

suspend fun brewCoffee(ground: String): String {
    delay(1000)
    return "${ground}으로 만든 커피"
}

suspend fun pourIntoCup(coffee: String): String {
    delay(1000)
    return "[컵] $coffee"
}

//fun main() = runBlocking {
//    val time = measureTimeMillis {
//        val result = async(dispatcher) {
//            val ground = grindBeans("케냐")
//            val coffee = brewCoffee(ground)
//            pourIntoCup(coffee)
//        }
//        println(result.await())
//    }
//    println("총 소요시간: ${time}ms")
//    (dispatcher.executor as ExecutorService).shutdown()
//}

//fun main() = runBlocking {
//    val orders = listOf("주문1", "주문2", "주문3", "주문4", "주문5", "주문6", "주문7", "주문8", "주문9", "주문10")
//    val time = measureTimeMillis {
//        orders.map { order ->
//            async(dispatcher) {
//                val ground = grindBeans(order)
//                val coffee = brewCoffee(ground)
//                val result = pourIntoCup(coffee)
//                "[$order] $result"
//            }
//        }.awaitAll().forEach(::println)
//    }
//    println("총 소요시간: ${time}ms")
//    (dispatcher.executor as ExecutorService).shutdown()
//}

//fun main() = runBlocking { // 코루틴 스코프가 생성
//    launch { // 새로운 코루틴이 시작이 됨.
//        delay(1000)
//        println("World!!")
//    }
//
//    launch { /* CPU 집약적인 작업 */ }
//    launch(Dispatchers.IO) { /* I/O 작업 */ }
//    launch(Dispatchers.Main) { /* UI 업데이트 */ }
//    launch(Dispatchers.Unconfined) { /* 제한 없음 */ }
//    println("Hello, ")
//}

fun main() = runBlocking {// 최상위 코루틴 함수
    coroutineScope {// 자식 스코프
        val job: Job = launch { // 손자 스코프
            println()
        }

        val deferred: Deferred<String> = async {
            delay(1000)
            "결과물"
        }
        println(deferred.await())
    }

    coroutineScope {

    }
}