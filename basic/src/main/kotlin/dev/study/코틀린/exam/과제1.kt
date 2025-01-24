package dev.study.코틀린.exam

/**
 * 1.1 변수 선언과 타입추론
 *  val 과 var 를 사용해서 이름, 나이, 직업을 나타내는 변수를 선언하세요
 *  직업 변수를 변경하고, 변경된 값을 출력하세요
 *  타입을 명시적으로 선언한 변수와 타입 추론을 사용한 변수를 각각 하나씩 작성 해주세요.
 *
 *  예상 출력:
 *  이름: Alice, 나이: 25, 직업: 디자이너
 *  변경된 직업: 개발자
 */

data class User (
    val name: String,
    val age: Long,
    var job: String,
)

//fun main() {
//    val user = User("Alice", 25, "디자이너")
//    println("이름: ${user.name}, 나이: ${user.age}, 직업: ${user.job}")
//    user.job = "개발자"
//    println("이름: ${user.name}, 나이: ${user.age}, 직업: ${user.job}")
//
//}

/**
 * 1.2 Nullable 타입과 Null Safety
 * - nullable 타입 변수 name 과 age 를 선언해주세요
 * - name 과 age 의 값을 출력 하되, 값이 없을 경우에 "Unknown" 과 0을 출력해주세요.
 */

fun main() {
    val name: String? = null
    val age: Int? = null

    println(name ?: "Unknown")
    println(age ?: 0)
}
