package com.michaeltroger.latintocyrillic.alphabets

/**
 * Supports 1 or 2 latin script characters translated to 1 cyrillic character
 */
internal abstract class LatinCyrillicAlphabet {

    protected abstract val latinToCyrillicAlphabet: Map<String, String>

    private val cyrillicToLatinAlphabet by lazy {
        latinToCyrillicAlphabet.entries.associate { it.value to it.key }
    }

    fun getLatinToCyrillicMap(): Map<String, String> = HashMap(latinToCyrillicAlphabet)
    fun getCyrillicToLatinMap(): Map<String, String> = HashMap(cyrillicToLatinAlphabet)
}
