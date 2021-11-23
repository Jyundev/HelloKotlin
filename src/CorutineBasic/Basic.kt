package CorutineBasic

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

fun main(){


    GlobalScope.launch {
        delay(1000L)
        println("world")
    }
//    thread{
//        Thread.sleep(1000L)
//        println("world")
//    }
    println("Hello, ")

    runBlocking {
        delay(2000L)
    }
}