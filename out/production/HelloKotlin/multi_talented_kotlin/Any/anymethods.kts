package multi_talented_kotlin.Any

import java.lang.StringBuilder

class Mailer {
    val details = StringBuilder()
    fun from(add: String) = details.append("from $add\n")
    fun to(add: String) = details.append("to $add\n")
    fun subect(line: String) = details.append("subject : $line\n")
    fun body(message: String) = details.append("message : $message\n")
    fun send()=details.append("happy christmas\n")
}
val mail=Mailer()
mail.from("jyub")
mail.to("???")
mail.subect("hello")
mail.body("My first message")
val message =mail.send()

val mailer2=Mailer().apply {
    from("jyub")
    to("???")
    subect("hello")
    body("My first message")
}
val message2 =mailer2.send()

val mailer3=Mailer().run {
    from("jyub")
    to("???")
    subect("hello")
    body("My first message")
    send()
}
println(mailer2)
println(mailer3)


fun createMailer()=Mailer()
fun prepareAndSend(mailer:Mailer)=mailer.run {
    from("jyub")
    to("???")
    subect("hello")
    body("My first message")
    send()
}

val result=prepareAndSend(createMailer())
println("result\n$result")

//val result2=createMailer().let{prepareAndSend(it)}
val result2=createMailer().let(::prepareAndSend)
println("result2\n$result2")

fun prepareMailer(mailer:Mailer):Unit{
    mailer.run {
        from("jyub")
        to("???")
        subect("hello")
        body("My first message")
    }
}
fun sendMail(mailer:Mailer):Unit{
    mailer.send()
    println("mail sent")
}

createMailer().also(this::prepareMailer).also (this::sendMail).details