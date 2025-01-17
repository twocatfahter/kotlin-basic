package dev.study.condition


fun main() {

    val day = 2

    val result = when (day) {
        1, 2, 4 -> "월요일"
        3 -> "수요일"
        5 -> "금요일"
        6 -> "토요일"
        7 -> "월요일"
        else -> "요일을 잘 못 입력하셨습니다."
    }

    println(result)
}