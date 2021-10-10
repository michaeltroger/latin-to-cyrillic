package com.michaeltroger.latintocyrillic.serbian

import com.michaeltroger.latintocyrillic.Alphabet
import com.michaeltroger.latintocyrillic.LatinCyrillic
import com.michaeltroger.latintocyrillic.LatinCyrillicImpl
import com.michaeltroger.latintocyrillic.runBlockingTest
import kotlin.test.*


internal class SerbianAutoConvertTest {

    private lateinit var converter: LatinCyrillic

    @BeforeTest
    fun setUp() {
        converter = LatinCyrillicImpl(Alphabet.Serbian)
    }

    @Test
    fun testEdgeCases() = runBlockingTest {
        assertFalse(converter.isCyrillic(""))
        assertFalse(converter.isCyrillic("."))
        assertFalse(converter.isCyrillic(","))
        assertFalse(converter.isCyrillic("!"))
        assertFalse(converter.isCyrillic("?"))
    }

    @Test
    fun verifyLatinToCyrillic() = runBlockingTest {
        assertFalse(converter.isCyrillic("Hello"))
        assertFalse(converter.isCyrillic(
                "Procenjena vrednost fabrike je veća od 514 miliona dinara (4.373.000 evra), a kako je ponuda manja od 50 odsto procenjene vrednosti, saglasnost za prodaju dao je odbor poverilaca."))
        assertFalse(converter.isCyrillic(".,!Hello"))
    }

    @Test
    fun verifyCyrillicToLatin() = runBlockingTest {
        assertTrue(converter.isCyrillic("Хелло"))
        assertTrue(converter.isCyrillic(
                    "Процењена вредност фабрике је већа од 514 милиона динара (4.373.000 евра), а како је понуда мања од 50 одсто процењене вредности, сагласност за продају дао је одбор поверилаца."))
        assertTrue(converter.isCyrillic(".,!Хелло"))
    }
}