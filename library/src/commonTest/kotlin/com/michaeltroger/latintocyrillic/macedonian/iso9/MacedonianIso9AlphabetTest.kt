package com.michaeltroger.latintocyrillic.macedonian.iso9

import com.michaeltroger.latintocyrillic.alphabets.LatinCyrillicAlphabet
import com.michaeltroger.latintocyrillic.alphabets.MacedonianIso9Alphabet
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals


internal class MacedonianIso9AlphabetTest {

    private lateinit var repo: LatinCyrillicAlphabet

    @BeforeTest
    fun setUp() {
        repo = MacedonianIso9Alphabet()
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
        assertEquals(2, max) // latin 2 letters - as some not part of unicode
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