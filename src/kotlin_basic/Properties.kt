package kotlin_basic

import javax.security.auth.Subject

//top level
const val MY_CONST = "const"

@Deprecated(MY_CONST)
fun main(args: Array<String>) {

    var obj = Address()
    println(obj.name)
    println(obj.isEmpty)
}

//프로퍼티 선언
class Address {
    lateinit var data: String

    //지역변수처럼 모이지만 다름!
    var name: String = "Kotlin"
        get() {
            return "$field!!!!"
        }
        set(value) {
            field = value
        }
    val city: String = "Seoul"

    val isEmpty
        get() = this.name == "Kotlin"

    val isEmpty_ = false
        get() {
            return field
        }

    fun setUp() {
        data = "나중에"
    }
}

//프로퍼티의 사용은 자바의 필드를 사용하듯 하면 됨
fun copyAddress(address: Address): Address {
    val result = Address()
    result.name = address.name

    return result
}



