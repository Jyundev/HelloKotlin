/**created by yun 2021-11-21**/


///Basic Types
fun main(array: Array<String>) {

    string()
}

//fun check(c:Char){
//    if(c==1){ //error
//
//    }
//}

fun type(){
    var a: Int? = 10000  //integer
    var b: Int = 10000   //int

    println(a == b) //true
    println(a === b) //false

}
fun check(c: Char) {
    if (c == '1') {

    }
}

//배열
fun array(){
    var arrayString: Array<String> = arrayOf("코틀린","강좌")
    println(arrayString.get(0))
    println(arrayString[0])

    //Array
    val a=Array(5,{i->i.toString()})
    //arrayOf
    val b= arrayOf("0","1","2","3","4")

    for(c in b)
        print(c)
    println()
    for(c in a)
        print(c)

    val x:IntArray= intArrayOf(1,2,3)
    x[0]=7
}

//문자열
fun string(){
    //개행이나 어떠한 문자 포함가능
    val s = """
        "Kotlin"
        
        """
    println(s)
}



