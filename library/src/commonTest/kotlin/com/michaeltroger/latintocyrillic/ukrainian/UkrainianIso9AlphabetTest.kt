package com.michaeltroger.latintocyrillic.ukrainian

import com.michaeltroger.latintocyrillic.alphabets.LatinCyrillicAlphabet
import com.michaeltroger.latintocyrillic.alphabets.UkrainianIso9Alphabet
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals


internal class UkrainianIso9AlphabetTest {

    private lateinit var repo: LatinCyrillicAlphabet

    @BeforeTest
    fun setUp() {
        repo = UkrainianIso9Alphabet()
    }

    @Test
    fun verifyAlphabetSize() {
        assertEquals(65, repo.getCyrillicToLatinMap().size)
        assertEquals(65, repo.getLatinToCyrillicMap().size)
    }

    @Test
    fun verifyMaxLatinCharacter() {
        var max = 0
        repo.getLatinToCyrillicMap().keys.forEach {
            if (it.length > max) {
                max = it.length
            }
        }
        assertEquals(2, max) // 2 letters in latin - not in unicode
    }

    @Test
    fun verifyMaxCyrillicCharacter() {
        var max = 0
        repo.getCyrillicToLatinMap().keys.forEach {
            if (it.length > max) {
                max = it.length
            }
        }
        assertEquals(1, max)
    }
}