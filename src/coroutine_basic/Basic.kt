package coroutine_basic

import kotlinx.coroutines.*

fun main() {

    example2()
}

fun example1() {

    runBlocking {
        GlobalScope.launch {
            delay(1000L)
            println("world")
        }
//    thread{
//        Thread.sleep(1000L)
//        println("world")
//    }
        println("Hello, ")
        //1초뒤에 world를 찍어야되기 때문에 2초 delay
        delay(2000L)
    }

}

fun example2() =

    runBlocking {
        val job = GlobalScope.launch {
            delay(1000L)
            println("world")
        }


        println("Hello, ")
        job.join() //join을 사용해서 코루틴이 완료될때까지 기다렸다가 종료
    }


fun structure() =

    runBlocking {

        this.launch {
            delay(1000L)
            println("world")
        }

        launch {
            delay(1000L)
            println("world")
        }

        println("Hello, ")
        //join을 하지않아도 world를 기다려줌 >>부모 코루틴이 하위 코루틴을 다 기다려준다
        //  job.join()
    }

fun suspendFuc() =

    runBlocking {

        launch {
//            delay(1000L)
//            println("world")
            //suspend func은 코루틴 안에서만 호출가능
            myWorld()
        }
        println("Hello, ")
        //join을 하지않아도 world를 기다려줌 >>부모 코루틴이 하위 코루틴을 다 기다려준다
        //  job.join()
    }

suspend fun myWorld() {
    delay(1000L)
    println("world")

}

//스레드와 비교시 메모리 오류가 훨씬 적음
fun repeatFunc() = runBlocking {
    repeat(1000) { i ->
        launch {
            println("I'm sleeping $i")

            delay(500L)
        }
    }
    delay(1300L)

}

fun waitFunc() = runBlocking {

    launch {
        repeat(5) { i ->
            println("Coroutine A, $i")
            delay(10L)
        }
    }

    launch {
        repeat(5) { i ->
            println("Coroutine B, $i")
            delay(10L)

        }
    }

    println("Coroutine Outer, ")

}

fun<T>println(msg:T){
    kotlin.io.println("$msg [${Thread.currentThread().name}]")
}