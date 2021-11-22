fun main(args:Array<String>) {
    val obj = User("Kotlin", 10)
    val obj2 = DataClass("hello")
    val obj3 = DataClass(age = 20)

//    println(obj)
//    println(obj2)
//    println(obj3)

    val jack=User("jack",20)
    val Ann=jack.copy("Ann") //복사해서 특정값만 변경가능
    val age_ = Ann.age

    //component1 component2
    val (name,age)= User("kris",23)
    println("$name $age")


    val o=NoData("1",1)
    val o1=User("1",1)
//    println(o)
//    println(o1)


    //간단한 데이터는 pair triple로 사용 가능
    val pair=Pair("Jane",35)
    val(name1,age1)=Pair("Lena",25)

    val Triple=Triple("Jane","Student",19)

}

data class User(var name : String, var age : Int){
    val other:Int=1
}
data class DataClass(var name : String="", var age : Int=10)

class NoData(var name : String, var age : Int)

