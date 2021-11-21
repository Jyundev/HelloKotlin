fun main() {

   for(i in fooLabel3())
       println("$i")
}

//label로 return 과 jump 가능
fun nonLabel() {
    loop@ for (i in 1..10) {
        println("---i $i ---")

        for (j in 1..10) {
            println("j : $j")
            if (j == 7) {
                break@loop
            }
        }
    }
}

fun label() {
    loop@ for (i in 1..10) {
        println("---i $i ---")

        for (j in 1..10) {
            println("j : $j")
            if (j == 7) {
                break
            }
        }
    }
}

fun foo() {
    var ints = listOf(0, 1, 2, 3)

    //함수가 중첩되어 있을때 retun은 그 함수만 종료
    ints.forEach(
        fun(value: Int) {
            if (value == 2) return
            print(value)
        }
    )
}

fun foo2() {
    var ints = listOf(0, 1, 2, 3)

    ints.forEach {
        if (it == 2) return // 2 이후에 return
        print(it)
    }
    println("end")
}

fun fooLabel() {
    println()
    var ints = listOf(0, 1, 2, 3)

    ints.forEach label@{
        if (it == 2) return@label // 람다에서 return : 2 이후에 return
        print(it)
    }
    println("end")
}

fun fooLabel2() {
    var ints = listOf(0, 1, 2, 3)

    ints.forEach {
        if (it == 2) return@forEach // 람다에서 return : 2 이후에 return
        print(it)
    }
    println("end")
}

fun fooLabel3(): List<String> {
    var ints = listOf(0, 1, 2, 3)

    val result=ints.map {
        if (it == 2) {
            return@map "zero"
        }
        "number $it"
    }
    return result
}