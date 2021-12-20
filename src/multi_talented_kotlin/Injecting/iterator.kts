package multi_talented_kotlin.Injecting

import java.lang.StringBuilder
import kotlin.collections.Iterator

val words: ClosedRange<Char> = 'a'..'e'
println(words.contains('f'))
for (word in 'a'..'e')
    print("$word, ")

val seekHelp: ClosedRange<String> = "held".."helu"
//for (word in "held".."helu")
//    print("$word, ")

// For-loop range must have an 'iterator()' method


operator fun ClosedRange<String>.iterator() =
    object : Iterator<String> {
        private val next = StringBuilder(start)
        private val last = endInclusive
        override fun hasNext() =
            last >= next.toString() && last.length >= next.length

        override fun next(): String {
            val result = next.toString()
            val lastCharacter = next.last()
            if (lastCharacter < Char.MAX_VALUE)
                next.setCharAt(next.length - 1, lastCharacter + 1)
            else
                next.append(Char.MIN_VALUE)

            return result
        }

    }

for (word in "held".."helu")
    print("$word, ")
