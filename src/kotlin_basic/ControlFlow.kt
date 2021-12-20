package kotlin_basic

fun main() {

    collection()
}

fun conditional(a: Int, b: Int) {
//if
    val max = if (a > b) {
        println("max : a")
        a //블록의 마지막값이 반환됨
    } else {
        println("max : b")
        b
    }
    print("max : $max")

}

fun switch(x: Int) {
    when (x) {
        1 -> println("x==$x")
        2 -> println("x==$x")
        else -> println("x==$x")
    }

    when (x) {
        0, 1 -> println("x== 0 or 1")
        2 -> println("x==$x")
        else -> println("x==$x")
    }

    val validNumbers = listOf(3, 6, 9)
    when (5) {
        in validNumbers -> print("x is valid")
        in 1..10 -> print("x is in range")
        !in 10..20 -> println("not x is in range")

    }

    when (true) {
        true -> "맞다"
        false -> "틀리다"
    }

    fun hasPrefix(x: Any) = when (x) {
        is String -> x.startsWith("prefix")
        else -> false
    }
}

fun collection() {
    var collection = listOf(1, 2, 3, 4)
    //collection.iterator()
    for (item in collection) // for문은 iterator을 반환하는 객체만 들어올 수 있다.
        print("$item ")

    println()

    val array = arrayOf(1, 2, 3, 4)
    // array.iterator() //iterator을 반환할 수 있게됨
    for (i in array)
        println("$i : ${array[i - 1]}")


}


fun iteratorFor() {
    val myData = MyIterator.MyData()
    myData.iterator()
    for (item in myData) {
        print(item)
    }

    val array = arrayOf("가", "나", "다")
    for (i in array.indices) { // i in array >> array[i] error
        println("$i : ${array[i]}")
    }

    for ((index, value) in array.withIndex()) {
        println("$index : ${value}")
    }
}

class MyIterator {
    val data = listOf(1, 2, 3, 4, 5)
    var idx = 0
    operator fun hasNext(): Boolean { //operator를 제거하면 for문에 들어갈수없음
        return data.size > idx
    }

    operator fun next(): Int {
        return data[idx++]
    }


    class MyData {
        operator fun iterator(): MyIterator {
            return MyIterator()
        }

    }
}
