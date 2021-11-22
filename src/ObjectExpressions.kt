//object >> 객체 생성시 사용

//최초 접근시 생성
object MyClass_1{
    init {
        println("create1")
    }

}
object MyClass_2{
    init {
        println("create2")
    }

}
object MyClass_3{
    init {
        println("create3")
    }

}
class MyRunnable : Runnable {
    override fun run() {
        TODO("Not yet implemented")
    }

}

fun main() {
    //class 를 따로 만들지 않고 object로 표현 가능
    val t = Thread(object : Runnable {
        override fun run() {
            println("hello")
        }

    })
    t.run()

    val myobj = Thread(object : Runnable {
        override fun run() {
            println("myobj")
        }

    })
    val th = Thread(myobj)
    th.run()

    val adHoc = object {
        var x: Int = 0
        var y: Int = 0
    }


    CounterManger.count++
    println(CounterManger.count)
    val instance=MyClass.create()

    println(1)
    println(MyClass_1)
    println(2)
    println(MyClass_2)
    println(3)
    println(MyClass_3)



}

class MyClass {

    companion object Factory{
        fun create():MyClass=MyClass()
    }
    private fun foo() = object {
        val x = "x"
    }

    fun publicFoo() = object {
        var y = "y"
    }

    fun print() {
        println(publicFoo())
        println(foo())
        val x1=foo().x
        //val x2=publicFoo().y error

    }
}

object CounterManger{
    var count=0
}

