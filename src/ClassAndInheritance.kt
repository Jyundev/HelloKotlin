import java.util.logging.Logger
import kotlin.math.log

//클래스와 상속
fun main(){
    val obj=Person("kotlin")
    obj.fullname="monster"
    println(obj.fullname)

}

//기본생성자 : constructor 생략가능
class Person constructor(firstName:String){
    var fullname:String=firstName //프로퍼티 get set 사용가능

    //보조생성자
    //직접적
    constructor(name : String,parent:Person):this(name){

    }

    //간접적
    constructor():this("홍길동",Person()){

    }
    //초기화
    init {

    }
}

class DontCreate private constructor(){

}
