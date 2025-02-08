package com.michaeltroger.latintocyrillic.bulgarian

import com.michaeltroger.latintocyrillic.alphabets.BulgarianIso9Alphabet
import com.michaeltroger.latintocyrillic.alphabets.LatinCyrillicAlphabet
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals


internal class BulgarianIso9AlphabetTest {

    private lateinit var repo: LatinCyrillicAlphabet

    @BeforeTest
    fun setUp() {
        repo = BulgarianIso9Alphabet()
    }

    @Test
    fun verifyAlphabetSize() {
        assertEquals(58, repo.getCyrillicToLatinMap().size)
        assertEquals(58, repo.getLatinToCyrillicMap().size)
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