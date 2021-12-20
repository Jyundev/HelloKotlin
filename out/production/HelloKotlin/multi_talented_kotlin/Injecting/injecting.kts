package multi_talented_kotlin.Injecting


data class Member(val name: String, val age: Int)

//함수 인젝팅
fun Member.adult() = this.age >= 20

val member = Member("Sehun", 28)
println("Sehun is Adult : ${member.adult()}")

data class Group(val name: String, val memberList: List<Member>)

infix fun Group.isMember(member: Member) =
    run {
        if (member in memberList)
            println("${member.name} is ${this.name}")
        else
            println("${member.name} is not ${this.name}")
    }

val group = Group(
    "the boys", listOf(
        Member("현재", 25), Member("주연", 24),
        Member("영훈", 25), Member("선우", 22)
    )
)

group.isMember(member)
group isMember member

//속성 인젝팅
val Member.isVocal: Boolean
    get() = name in listOf("현재", "영훈")

val member2 = Member("선우", 22)
println("${member2.name} position is vocal : ${member2.isVocal}")

//서드파티 클래스 인젝팅

fun String.isTheboys(): Boolean {
    return this in listOf("현재", "주연", "영훈", "선우")
}

println("현재".isTheboys())

