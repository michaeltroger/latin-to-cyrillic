package com.michaeltroger.latintocyrillic.russian


import com.michaeltroger.latintocyrillic.alphabets.LatinCyrillicAlphabet
import com.michaeltroger.latintocyrillic.alphabets.RussianIso9Alphabet
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals


internal class RussianIso9AlphabetTest {

    private lateinit var repo: LatinCyrillicAlphabet

    @BeforeTest
    fun setUp() {
        repo = RussianIso9Alphabet()
    }

    @Test
    fun verifyAlphabetSize() {
        assertEquals(63, repo.getCyrillicToLatinMap().size)
        assertEquals(63, repo.getLatinToCyrillicMap().size)
    }

    @Test
    fun verifyMaxLatinCharacter() {
        var max = 0
        repo.getLatinToCyrillicMap().keys.forEach {
            if (it.length > max) {
                max = it.length
            }
        }
        assertEquals(1, max)
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