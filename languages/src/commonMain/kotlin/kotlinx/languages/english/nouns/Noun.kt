package kotlinx.languages.english.nouns

abstract class Noun(private val noun: String) {

    open fun possessiveForm(): String = toString()

    override fun toString() = noun

}

