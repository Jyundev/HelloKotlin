package CoroutineBasic

import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

/**
 * 2020.06.24, created by 새차원
 * https://blog.naver.com/cenodim
 * https://www.youtube.com/channel/UCJeARDV434voq3IxRTBfzLw
 */

fun main() {
    kotlin.io.println("[in] main")
    myCoroutine(MyContinuation())
    kotlin.io.println("\n[out] main")
}

fun myCoroutine(cont: MyContinuation) {
    when(cont.label) {
        0 -> {
            kotlin.io.println("\nmyCoroutine(), label: ${cont.label}")
            cont.label = 1
            fetchUserData(cont)
        }
        1 -> {
            kotlin.io.println("\nmyCoroutine(), label: ${cont.label}")
            val userData = cont.result
            cont.label = 2
            cacheUserData(userData, cont)
        }
        2 -> {
            kotlin.io.println("\nmyCoroutine(), label: ${cont.label}")
            val userCache = cont.result
            updateTextView(userCache)
        }
    }
}

fun fetchUserData(cont: MyContinuation) {
    kotlin.io.println("fetchUserData(), called")
    val result = "[서버에서 받은 사용자 정보]"
    kotlin.io.println("fetchUserData(), 작업완료: $result")
    cont.resumeWith(Result.success(result))
}

fun cacheUserData(user: String, cont: MyContinuation) {
    kotlin.io.println("cacheUserData(), called")
    val result = "[캐쉬함 $user]"
    kotlin.io.println("cacheUserData(), 작업완료: $result")
    cont.resumeWith(Result.success(result))
}

fun updateTextView(user: String) {
    kotlin.io.println("updateTextView(), called")
    kotlin.io.println("updateTextView(), 작업완료: [텍스트 뷰에 출력 $user]")
}

class MyContinuation(override val context: CoroutineContext = EmptyCoroutineContext)
    : Continuation<String> {

    var label = 0
    var result = ""

    override fun resumeWith(result: Result<String>) {
        this.result = result.getOrThrow()
        kotlin.io.println("Continuation.resumeWith()")
        myCoroutine(this)
    }
}


