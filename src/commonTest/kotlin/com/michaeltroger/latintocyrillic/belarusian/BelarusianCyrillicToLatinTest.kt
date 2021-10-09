package com.michaeltroger.latintocyrillic.belarusian

import com.michaeltroger.latintocyrillic.Alphabet
import com.michaeltroger.latintocyrillic.LatinCyrillicImpl
import com.michaeltroger.latintocyrillic.runBlockingTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

internal class BelarusianCyrillicToLatinTest {

    private lateinit var converter: LatinCyrillicImpl

    @BeforeTest
    fun setUp() {
        converter = LatinCyrillicImpl(Alphabet.BelarusianIso9)
    }

    @Test
    fun testEdgeCases() =
        runBlockingTest {
            val test = converter.cyrillicToLatin("")
            assertEquals(actual = test, expected = "")
        }


}