package com.michaeltroger.latintocyrillic.macedonian.academic

import com.michaeltroger.latintocyrillic.alphabets.LatinCyrillicAlphabet
import com.michaeltroger.latintocyrillic.alphabets.MacedonianAlphabet
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals


internal class MacedonianAlphabetTest {

    private lateinit var repo: LatinCyrillicAlphabet

    @BeforeTest
    fun setUp() {
        repo = MacedonianAlphabet()
    }

    @Test
    fun verifyAlphabetSize() {
        assertEquals(62, repo.getCyrillicToLatinMap().size)
        assertEquals(62, repo.getLatinToCyrillicMap().size)
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