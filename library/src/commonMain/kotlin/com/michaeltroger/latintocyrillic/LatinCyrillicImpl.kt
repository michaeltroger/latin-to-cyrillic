package com.michaeltroger.latintocyrillic

import com.michaeltroger.latintocyrillic.alphabets.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

internal class LatinCyrillicImpl : LatinCyrillic {

    private lateinit var repo: LatinCyrillicAlphabet

    constructor(latin: List<String>, cyrillic: List<Char>) {
        this.repo = CustomAlphabet(latin = latin, cyrillic = cyrillic)
    }

    constructor(alphabet: Alphabet) {
        this.repo = when (alphabet) {
            Alphabet.BelarusianIso9 -> BelarusianIso9Alphabet()
            Alphabet.BulgarianIso9 -> BulgarianIso9Alphabet()
            Alphabet.Macedonian -> MacedonianAlphabet()
            Alphabet.MacedonianIso9 -> MacedonianIso9Alphabet()
            Alphabet.RussianIso9 -> RussianIso9Alphabet()
            Alphabet.Serbian -> SerbianAlphabet()
            Alphabet.UkrainianIso9 -> UkrainianIso9Alphabet()
        }
    }

    private val latinToCyrillicMap by lazy {
        repo.getLatinToCyrillicMap()
    }
    private val cyrillicToLatinMap by lazy {
        repo.getCyrillicToLatinMap()
    }

    override suspend fun latinToCyrillic(text: String): String = withContext(Dispatchers.Default) {
        val convertedText = StringBuilder()
        var i = 0
        while (i < text.length) {
            val oneLookedUpChar = latinToCyrillicMap[text[i].toString()]
            val twoLookedUpChars = if (i + 1 >= text.length) null else latinToCyrillicMap[text[i].toString() + text[i + 1]]
            when {
                oneLookedUpChar.isNullOrEmpty() && twoLookedUpChars.isNullOrEmpty() -> convertedText.append(text[i]) // don't convert unknown chars
                twoLookedUpChars.isNullOrEmpty() -> convertedText.append(oneLookedUpChar)
                else -> {
                    convertedText.append(twoLookedUpChars)
                    i++
                }
            }
            i++
        }
        convertedText.toString()
    }

    override suspend fun cyrillicToLatin(text: String): String = withContext(Dispatchers.Default) {
        val convertedText = StringBuilder()
        text.forEach {
            val lookedUpChar = cyrillicToLatinMap[it.toString()]
            if (lookedUpChar.isNullOrEmpty()) {  // don't convert unknown chars
                convertedText.append(it)
            } else {
                convertedText.append(lookedUpChar)
            }
        }
        convertedText.toString()
    }

    override suspend fun isCyrillic(text: String): Boolean {
        text.forEachIndexed { i, t ->
            val oneChar = t.toString()
            val twoChars = if (i + 1 >= text.length) null else t.toString() + text[i + 1]
            if (cyrillicToLatinMap.containsKey(oneChar)) {
                return true
            } else if (latinToCyrillicMap.containsKey(oneChar) || twoChars != null && latinToCyrillicMap.containsKey(twoChars)) {
                return false
            }
        }

        return false
    }

    override suspend fun getLatinAlphabet(): List<String> = withContext(Dispatchers.Default) {
        latinToCyrillicMap.keys.sorted()
    }
    override suspend fun getCyrillicAlphabet(): List<String> = withContext(Dispatchers.Default) {
        latinToCyrillicMap.keys.sorted().map {
            latinToCyrillicMap[it] ?: ""
        }
    }
}