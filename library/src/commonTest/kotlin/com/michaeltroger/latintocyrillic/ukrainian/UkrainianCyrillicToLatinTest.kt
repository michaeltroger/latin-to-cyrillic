package com.michaeltroger.latintocyrillic.ukrainian

import com.michaeltroger.latintocyrillic.Alphabet
import com.michaeltroger.latintocyrillic.LatinCyrillic
import com.michaeltroger.latintocyrillic.LatinCyrillicImpl
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals


internal class UkrainianCyrillicToLatinTest {

    private lateinit var converter: LatinCyrillic

    @BeforeTest
    fun setUp() {
        converter = LatinCyrillicImpl(Alphabet.UkrainianIso9)
    }

    @Test
    fun testEdgeCases() = runTest {
        assertEquals("", converter.cyrillicToLatin(""))
        assertEquals(".", converter.cyrillicToLatin("."))
        assertEquals(",", converter.cyrillicToLatin(","))
        assertEquals("!", converter.cyrillicToLatin("!"))
        assertEquals("?", converter.cyrillicToLatin("?"))
    }

    @Test
    fun testAlphabet() = runTest { // verified with: https://www.translitteration.com/transliteration/en/russian/iso-9/
            assertEquals(""""
A a	B b	V v	G g	G̀ g̀	D d	E e	Ê ê	Ž ž	Z z	I i
Ì ì	Ï ï	J j	K k	L l	M m	N n	O o	P p	R r	S s
T t	U u	F f	H h	C c	Č č	Š š	Ŝ ŝ	 ʹ	Û û	Â â
""",
                converter.cyrillicToLatin(
                    """"
А а	Б б	В в	Г г	Ґ ґ	Д д	Е е	Є є	Ж ж	З з	И и
І і	Ї ї	Й й	К к	Л л	М м	Н н	О о	П п	Р р	С с
Т т	У у	Ф ф	Х х	Ц ц	Ч ч	Ш ш	Щ щ	 ь	Ю ю	Я я
"""
            ))
        }

    @Test
    fun testAlphabetFromTransliteration() = runTest { // verified with: https://www.translitteration.com/transliteration/en/russian/iso-9/
            assertEquals( """"
aabbvvggg̀g̀ddeeêêžžzziiììïïjjkkllmmnnoopprrssttuuffhhccččššŝŝûûââʹʹ’’
AABBVVGGG̀G̀DDEEÊÊŽŽZZIIÌÌÏÏJJKKLLMMNNOOPPRRSSTTUUFFHHCCČČŠŠŜŜÛÛÂÂ′’’
""",
                converter.cyrillicToLatin(
                    """"
аaбbвvгgґg̀дdеeєêжžзzиiіìїïйjкkлlмmнnоoпpрrсsтtуuфfхhцcчčшšщŝюûяâьʹ’’
АAБBВVГGҐG̀ДDЕEЄÊЖŽЗZИIІÌЇÏЙJКKЛLМMНNОOПPРRСSТTУUФFХHЦCЧČШŠЩŜЮÛЯÂ′’’
"""
            ))
        }
    }