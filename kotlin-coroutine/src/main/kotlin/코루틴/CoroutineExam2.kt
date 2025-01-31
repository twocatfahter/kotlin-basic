package 코루틴

import kotlin.system.measureTimeMillis

fun downloadImage(url: String): String {
    Thread.sleep(3000)
    return "이미지 데이터: $url"
}

fun saveToDisk(image: String) {
    Thread.sleep(2000)
    println("저장완료: ${image.take(15)}...")
}

// 동기 버전
fun downloadSync(urls: List<String>) {
    urls.forEach { url ->
        val image = downloadImage(url)
        saveToDisk(image)
    }
}

fun main() {
    // 이미지 다운로드 테스트
    val urls = listOf("url1", "url2", "url3")

    // 동기 버전
    val syncTime = measureTimeMillis {
        downloadSync(urls)
    }

    println("동기 다운로드시간: ${syncTime}ms")
}

