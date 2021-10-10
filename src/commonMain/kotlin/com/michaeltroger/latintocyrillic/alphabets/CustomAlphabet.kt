package com.michaeltroger.latintocyrillic.alphabets


internal class CustomAlphabet(latin: List<String>, cyrillic: List<Char>) : LatinCyrillicAlphabet() {

    init {
        require(latin.size == cyrillic.size) {
            "Latin and Cyrillic alphabets must have same size. But have: Latin:${latin.size}/Cyrillic:${cyrillic.size}"
        }
        latin.forEach {
            require(it.isNotEmpty() && it.length < 3) {
                "Only 1 or 2 latin characters allowed to describe a letter in alphabet. But were:${it.length}/Letter:${it}\""
            }
        }
    }

    override val latinToCyrillicAlphabet: Map<String, String> by lazy {
        var i = 0
        latin.associateWith {
            cyrillic[i++].toString()
        }
    }
}
