package kotlinx.languages.english

import kotlinx.strings.*

/**@Description
 * For better names https://www.grammarly.com/blog/plural-nouns/
 * */
val String.plural: String
    get() = run {

        when (val string = lowercase()) {
            "fez" -> "fezzes"
            "gas" -> "gasses"
            "roof" -> "roofs"
            "belief" -> "beliefs"
            "chef" -> "chefs"
            "chief" -> "chiefs"
            "hove" -> "hooves"
            "photo" -> "photos"
            "piano" -> "pianos"
            "halo" -> "halos"
            "sheep" -> "sheep"
            "series" -> "series"
            "species" -> "species"
            "deer" -> "deer"
            "fish" -> "fish"
            "child" -> "children"
            "goose" -> "geese"
            "man" -> "men"
            "woman" -> "women"
            "tooth" -> "teeth"
            "foot" -> "feet"
            "mouse" -> "mice"
            "person" -> "people"
            else -> when (string.last()) {
                'y' -> when (string[2::last].isVowel) {
                    true -> "${this}s"
                    false -> this replace -1 with "ies"
                }
                'f' -> "${this[0 to length - 1]}ves"
                'e' -> when {
                    string[2::last] == 'f' -> this replace -2 with "ves"
                    else -> "${this}s"
                }
                'o' -> "${this}es"
                's' -> when {
                    string[2::last] == 'u' -> if (length > 3) this replace -2 with "i" else "${this}es"
                    string[2::last] == 'i' -> this replace -2 with "es"
                    string[2::last] == 's' -> "${this}es"
                    else -> ""
                }
                'h' -> when (string[2::last]) {
                    's', 'c' -> "${this}es"
                    else -> "${this}s"
                }
                'x', 'z' -> "${this}es"
                else -> when (string[2::lastChars]) {
                    "on" -> when (string) {
                        "permission" -> "permissions"
                        "caution" -> "cautions"
                        else -> string replace -2 with "a"
                    }
                    else -> "${this}s"
                }
            }
        }
    }

fun nonConsonantYEnding(string: String): Boolean {
    val l = string.length
    return if (l != 0) string[l - 1] == 'y' && l > 2 && string[l - 2].isVowel
    else false
}


val vowels = setOf('a', 'e', 'i', 'o', 'u')

val Char.isVowel
    get() = this in vowels