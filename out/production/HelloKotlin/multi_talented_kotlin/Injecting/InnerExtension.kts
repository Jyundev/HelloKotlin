package multi_talented_kotlin.Injecting

//확장 함수를 클래스 안에서 만들기
class Pointer(x: Int, y: Int) {
    private val pair = Pair(x, y)
    private val firstsign = if (pair.first < 0) "" else ""
    private val secondsign = if (pair.second < 0) "" else "+"

    fun Pair<Int, Int>.printValue() =
        "first  : ${this@Pointer.firstsign}${first} , second : ${this@Pointer.secondsign}${second}"

    override fun toString() = pair.printValue()

}

println(Pointer(3, -4))
println(Pointer(-3, 8))