package dev.study

/**
 *  첫번째 파라미터는 name 입니다.
 *  두번째 파라미터는 surname 입니다.
 *  마지막은 age 입니다.
 *  모든 파라미터는 Nullable한 형태입니다.
 *  파라미터 값이 존재하지 않는다면 그 값을 제외하고 아래 형식대로 출력 하셔야합니다.
 *
 */
fun formatPersonDisplayAnswer(
    name: String? = null,
    surname: String? = null,
    age: Int? = null,
): String {
    var result = ""
    if (name != null) {
        result += name
    }

    if (surname != null) {
        result += " $surname"
    }

    if (age != null) {
        result += " ($age)"
    }

    return result.trim()
}


/**
 *  람다표현식, 고차함수 사용하여 다음 문제 해결해주세요
 *  - 정수 리스트에서 짝수만 필터링해서 출력해주세요
 *  - 고차 함수를 작성해서 두 숫자를 더하거나 곱하는 람다 표현식을 전달하고 결과를 출력해주세요.
 *
 *  멀티 모듈
 *  api, core, infrastructure
 *
 *  api -> core <- infrastructure
 *  core entity
 *  User
 */

class User(
    val name: String,
    val age: Int,

) {

}

data class UserRequest(
    val name: String,
    val age: Int,
)

fun User.toEntity() = User(
    name,
    age,
)


// 확장함수
fun List<Int>.filterEven(): List<Int> = this.filter { it % 2 == 0 }

val numbers = listOf(1,2,3,4,5,6,7,8,9,10)

val evenNumbers = numbers.filterEven()

fun calculate(a: Int, b: Int, operation: (Int, Int) -> Int) = operation(a,b)

//fun main() {
//    println(evenNumbers)
//    calculate(1,4) { x , y -> x + y}
//}

fun main() {
    println(formatPersonDisplayAnswer("John", "Smith", 42))
    // John, Smith, 42
    println(formatPersonDisplayAnswer("Alex", "Simonson"))
    // Alex, Simonson
    println(formatPersonDisplayAnswer("Peter", age = 25))
    //Peter, 25
    println(formatPersonDisplayAnswer(surname = "Johnson", age = 18))
    //Johnson, 18
}