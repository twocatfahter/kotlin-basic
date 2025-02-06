package 코루틴

import kotlinx.coroutines.*
import java.util.concurrent.Executors
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

// 비동기
fun downloadAsync(urls: List<String>) {
    val executor = Executors.newFixedThreadPool(urls.size)

    urls.forEach { url ->
        executor.submit {
            val image = downloadImage(url)
            saveToDisk(image)
        }
    }
}

// 코루틴
suspend fun downloadCoroutine(urls: List<String>) = coroutineScope {
    urls.map { url ->
        async(Dispatchers.IO) {
            val image = downloadImage(url)
            withContext(Dispatchers.Default) {
                saveToDisk(image)
            }
        }
    }.awaitAll()
}

fun main() = runBlocking {
    // 이미지 다운로드 테스트
    val urls = listOf("url1", "url2", "url3")

    // 동기 버전
    val syncTime = measureTimeMillis {
        downloadSync(urls)
    }

    println("동기 다운로드시간: ${syncTime}ms")

    val threadPoolTime = measureTimeMillis {
        downloadAsync(urls)
    }
    println("스레드 풀 비동기 시간: ${threadPoolTime}ms")

    // 코루틴 버전
    val asyncTime = measureTimeMillis {
        downloadCoroutine(urls)
    }
    println("코루틴 다운로드 시간: ${asyncTime}ms")
}

