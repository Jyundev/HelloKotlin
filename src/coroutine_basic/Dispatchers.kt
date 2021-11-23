package coroutine_basic

import kotlinx.coroutines.*

fun log(msg: String) = coroutine_basic.println("[${Thread.currentThread().name}] $msg")


fun main() =
    runBlocking<Unit> {
        val a = async {
            log("I'm computing a piece of the answer")
            6
        }
        val b = async {
            log("I'm computing another piece of the answer")
            7
        }

        log("The answer is ${a.await() * b.await()}")

    }


fun dispatcherFunc() = runBlocking<Unit> {

    launch {
        println("main runBlocking : I'm working in thread ${Thread.currentThread().name}")
    }
    launch(Dispatchers.Unconfined) {
        println("Unconfined : I'm working in thread ${Thread.currentThread().name}")
    }
    launch(Dispatchers.Default) {
        println("Default : I'm working in thread ${Thread.currentThread().name}")
    }
    newSingleThreadContext("MyOwnThread").use {
        launch(it) {
            println("newSingleThreadContext : I'm working in thread ${Thread.currentThread().name}")
        }
    }

}


