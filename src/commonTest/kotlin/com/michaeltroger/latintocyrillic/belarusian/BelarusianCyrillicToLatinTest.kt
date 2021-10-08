package com.michaeltroger.latintocyrillic.belarusian

import com.michaeltroger.latintocyrillic.Alphabet
import com.michaeltroger.latintocyrillic.CyrillicImpl
import com.michaeltroger.latintocyrillic.runBlockingTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

internal class BelarusianCyrillicToLatinTest {

    private lateinit var converter: CyrillicImpl

    @BeforeTest
    fun setUp() {
        converter = CyrillicImpl(Alphabet.BelarusianIso9)
    }

    @Test
    fun testEdgeCases() =
        runBlockingTest {
            val test = converter.cyrillicToLatin("")
            assertEquals(actual = test, expected = "")
        }


}