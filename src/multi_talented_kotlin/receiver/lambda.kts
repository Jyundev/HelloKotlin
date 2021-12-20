package multi_talented_kotlin.receiver

import java.lang.reflect.Type

//var length = "christmas"
//val printIt: (String) -> Unit = { food: String ->
//    println("my favoriteFood is : $food, length is $length ")
//}

//printIt("chocolate")

val printIt2: String.(String) -> Unit = { food: String ->
    println("my favoriteFood is : $food, favoriteDay is $this ")
}

printIt2("Christmas","Cake")

"Christmas".printIt2("Choco")