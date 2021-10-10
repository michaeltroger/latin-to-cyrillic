package com.michaeltroger.latintocyrillic.custom

import com.michaeltroger.latintocyrillic.LatinCyrillicImpl
import com.michaeltroger.latintocyrillic.runBlockingTest
import kotlin.test.Test
import kotlin.test.assertEquals

internal class CustomAlphabetSortOrderTest {

    @Test
    fun testSortedLatin() = runBlockingTest {
        val converter = LatinCyrillicImpl(latin = listOf("x", "c", "d", "b"), cyrillic = listOf('Ћ', 'Љ', 'П', 'Џ'))
        assertEquals(listOf("b", "c", "d", "x"), converter.getLatinAlphabet())
        assertEquals(listOf("Џ", "Љ", "П", "Ћ"), converter.getCyrillicAlphabet())
    }
}