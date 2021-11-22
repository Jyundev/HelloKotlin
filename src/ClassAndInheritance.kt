//클래스와 상속
fun main() {
//    val obj = Person("kotlin")
//    obj.fullname = "monster"
//    println(obj.fullname)

    val obj=C()
    obj.f()

}

//기본생성자 : constructor 생략가능
class Person constructor(firstName: String) {
    var fullname: String = firstName //프로퍼티 get set 사용가능

    //보조생성자
    //직접적
    constructor(name: String, parent: DataClass) : this(name) {

    }

    //간접적
    constructor() : this("홍길동", DataClass()) {

    }

    //초기화
    init {

    }
}

class DontCreate private constructor() {

}

//상속

//코틀린의  최상위 클래스 : any
//open class 만 상속가능  <> final과 반대
open class AA(x: Int) : Any() {

}

class BB(x: Int) : AA(x) {

}

//오버라이드
open class Base {
    //재정의 할려면 open
    var test1 = ""
    open var test2 = ""
    open fun v() {}
    fun nv() {}
}

class Devieded() : Base() {
    override fun v() {
        super.v()
    }

    override var test2: String
        get() = super.test2
        set(value) {}
}


//오버라이딩 규칙
open class A {
    open fun f() {
        print("A")
    }

    fun a() {
        print("a")
    }
}

interface B {
    fun f() {
        print("B")
    }

    fun b() {
        print("b")
    }
}

class C() : A(), B {
    //모호성 발생
//    override fun f() {
//        TODO("Not yet implemented")
//    }
//
//    override fun f() {
//        TODO("Not yet implemented")
//    }

    override fun f() {
        super<A>.f()
        super<B>.f()
    }

}


//추상
abstract class AbsClass{
    abstract fun f()
}
class Myclass():AbsClass(){
    override fun f() {
        TODO("Not yet implemented")
    }

}