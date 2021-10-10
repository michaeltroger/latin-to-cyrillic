package com.michaeltroger.latintocyrillic.serbian

import com.michaeltroger.latintocyrillic.alphabets.LatinCyrillicAlphabet
import com.michaeltroger.latintocyrillic.alphabets.SerbianAlphabet
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals


internal class SerbianAlphabetTest {

    private lateinit var repo: LatinCyrillicAlphabet

    @BeforeTest
    fun setUp() {
        repo = SerbianAlphabet()
    }

    @Test
    fun verifyAlphabetSize() {
        assertEquals(60, repo.getCyrillicToLatinMap().size)
        assertEquals(60, repo.getLatinToCyrillicMap().size)
    }

    @Test
    fun verifyMaxLatinCharacter() {
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
        var max = 0
        repo.getCyrillicToLatinMap().keys.forEach {
            if (it.length > max) {
                max = it.length
            }
        }
        assertEquals(1, max)
    }
}