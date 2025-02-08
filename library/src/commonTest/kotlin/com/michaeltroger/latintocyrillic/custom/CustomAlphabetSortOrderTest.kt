package com.michaeltroger.latintocyrillic.custom

import com.michaeltroger.latintocyrillic.LatinCyrillicImpl
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals

internal class CustomAlphabetSortOrderTest {

    @Test
    fun testSortedLatin() = runTest {
        val converter = LatinCyrillicImpl(latin = listOf("x", "c", "d", "b"), cyrillic = listOf('Ћ', 'Љ', 'П', 'Џ'))
        assertEquals(listOf("b", "c", "d", "x"), converter.getLatinAlphabet())
        assertEquals(listOf("Џ", "Љ", "П", "Ћ"), converter.getCyrillicAlphabet())
    }
}