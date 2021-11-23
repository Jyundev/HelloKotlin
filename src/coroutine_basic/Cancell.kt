package coroutine_basic

import kotlinx.coroutines.*
import java.lang.Exception

fun main() {
    timeoutFunc()
}

fun cancelFunc() = runBlocking {
    val job = launch {
        repeat(1000) { i ->
            println("job : I'm sleeping $i ...")
            delay(500L)
        }
    }
    delay(1300L)
    println("main: I'm tired of waiting!")
    job.cancel()//취소
    job.join()//끝날때까지 대기
    println("main: Now I can quit")


}

fun cancelJoinFunc() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) { //==GlobalScope.launch()
        try {
            var nextPrintTime = startTime
            var i = 0
            while (i < 5) {
                if (System.currentTimeMillis() >= nextPrintTime) {
                    // delay(1L)//suspend func 가 없다면 cancel 안됨
                    yield() //Suspend 함수사 exception을 감지
                    println("job : I'm sleeping ${i++} ...")
                    nextPrintTime += 500L

                }
            }
        } catch (e: Exception) {
            kotlin.io.println("Exception ${e}")
        }

    }
    delay(1300L)
    println("main: I'm tired of waiting!")
    job.cancelAndJoin()
    println("main: Now I can quit")


}

fun activeFunc() = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (isActive) {
            if (System.currentTimeMillis() >= nextPrintTime) {
                // delay(1L)//suspend func 가 없다면 cancel 안됨
                // yield() //Suspend 함수사 exception을 감지
                println("job : I'm sleeping ${i++} ...")
                nextPrintTime += 500L

            }
        }
    }
    delay(1300L)
    println("main: I'm tired of waiting!")
    job.cancelAndJoin()
    println("main: Now I can quit")

}

fun finallyFunc() = runBlocking {
    val job = launch {
        try {
            repeat(1000) { i ->
                println("job : I'm sleeping ${i} ...")
                delay(500L)

            }
        } finally {
            //resource 해제 시점
            println("job : I'm running finally")

        }

    }
    delay(1300L)
    println("main: I'm tired of waiting!")
    job.cancelAndJoin()
    println("main: Now I can quit")

}

fun finallyContextFunc() = runBlocking {
    val job = launch {
        try {
            repeat(1000) { i ->
                println("job : I'm sleeping ${i} ...")
                delay(500L)

            }
        } finally {
            withContext(NonCancellable) {
                println("job : I'm running finally")
                delay(1000)//1초 쉬고 코루틴 다시반환
                println("job : And i've just delayed for 1 sec because I'm non-cancellable ")


            }
        }
    }


    delay(1300L)
    println("main: I'm tired of waiting!")
    job.cancelAndJoin()
    println("main: Now I can quit")

}

fun timeoutFunc()= runBlocking {

    var result = withTimeoutOrNull(1300L){
        repeat(1000){ i->
            println("job : I'm sleeping $i ...")
            delay(500L)

        }
        "Done"
    }
    println("Result is $result")

}