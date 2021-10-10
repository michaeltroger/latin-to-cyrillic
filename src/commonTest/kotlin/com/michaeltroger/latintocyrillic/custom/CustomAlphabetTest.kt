package com.michaeltroger.latintocyrillic.custom

import com.michaeltroger.latintocyrillic.alphabets.CustomAlphabet
import kotlin.test.Test
import kotlin.test.assertEquals


internal class CustomAlphabetTest {

    @Test
    fun verifyAlphabetSize() {
        val repo = CustomAlphabet(latin = emptyList(), cyrillic = emptyList())
        assertEquals(0, repo.getCyrillicToLatinMap().size)
        assertEquals(0, repo.getLatinToCyrillicMap().size)
    }

    @Test
    fun verifyMaxLatinCharacter() {
        val repo = CustomAlphabet(latin = listOf("a", "bc"), cyrillic = listOf('Љ', 'Џ'))
        assertEquals(2, repo.getCyrillicToLatinMap().size)
        assertEquals(2, repo.getLatinToCyrillicMap().size)

        var max = 0
        repo.getLatinToCyrillicMap().keys.forEach {
            if (it.length > max) {
                max = it.length
            }
        }
        assertEquals(2, max)
    }

    @Test
    fun verifyMaxCyrillicCharacter() {
        val repo = CustomAlphabet(latin = listOf("a", "bc"), cyrillic = listOf('Љ', 'Џ'))
        var max = 0
        repo.getCyrillicToLatinMap().keys.forEach {
            if (it.length > max) {
                max = it.length
            }
        }
        assertEquals(1, max)
    }

}