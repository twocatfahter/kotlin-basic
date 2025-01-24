package dev.study.dataclass.exam

/**
 *  data class 와 companion object 를 활용하여 문제해결
 *  - 이름과 가격을 가지는 Product 데이터를 나타내는 클래스를 생성
 *  - companion object를 사용해서 샘플 데이터를 반환하는 정적 메서드를 작성하세요
 *  - 샘플 데이터를 출력해주세요
 */

//data class Product(
//    val name: String,
//    val price: Double,
//){
//    companion object {
//        fun sample() = listOf(
//            Product("Laptop", 1000.0),
//            Product("Phone", 1400.0)
//        )
//    }
//}


data class Product(
    val name: String,
    val price: Double,
)

class ProductFactory {
    companion object {
        fun createSampleProducts(): List<Product> {
            return listOf(
                Product("LapTop", 1500.0),
                Product("Phone", 1300.0)
            )
        }
    }
}

fun main() {
    val createSampleProducts = ProductFactory.createSampleProducts()
    createSampleProducts.forEach { println(it) }
}