package com.michaeltroger.latintocyrillic.repo

import com.michaeltroger.latintocyrillic.LatinCyrillicAlphabet
import kotlin.IllegalArgumentException

/**
 * Both must be of same size and correctly sorted
 */
internal class CustomAlphabet(latin: List<String>, cyrillic: List<Char>) : LatinCyrillicAlphabet() {

    init {
        if (latin.size != cyrillic.size) {
            throw IllegalArgumentException("Latin and Cyrillic alphabets must have same size. But have: Latin:${latin.size}/Cyrillic:${cyrillic.size}")
        }
    }

    override val latinToCyrillicAlphabet: Map<String, String> by lazy {
        var i = 0
        latin.associateWith {
            if (it.length > 2) {
                throw IllegalArgumentException("Only up to 2 latin characters allowed to describe a letter in alphabet. But were: Latin:${it.length}/${it}")
            }
            cyrillic[i++].toString()
        }
    }
}
