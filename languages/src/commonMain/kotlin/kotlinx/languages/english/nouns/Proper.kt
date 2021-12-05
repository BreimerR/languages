package kotlinx.languages.english.nouns

class Proper(noun: String) : Noun(noun) {
    override fun possessiveForm(): String = "${this}'s"
}
