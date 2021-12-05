package kotlinx.languages.english

val alphabets = setOf(
    'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
    'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
)

val Char.isAlphabet
    get() = this in alphabets

fun String.lastAlphabet(end: Int = this.length): Char? {
    return if (end > 0) {
        val char = this[end - 1]
        if (char.isAlphabet) char
        else lastAlphabet(end - 1)
    } else null
}

fun String.lastAlphabetIndex(end: Int = this.length): Int {
    return if (end > 0) {
        val index = end - 1
        val char = this[index]
        if (char.isAlphabet) index
        else lastAlphabetIndex(end - 1)
    } else -1
}