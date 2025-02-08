package com.michaeltroger.latintocyrillic.bulgarian


import com.michaeltroger.latintocyrillic.Alphabet
import com.michaeltroger.latintocyrillic.LatinCyrillic
import com.michaeltroger.latintocyrillic.LatinCyrillicImpl
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

internal class BulgarianCyrillicToLatinTest {

    private lateinit var converter: LatinCyrillic

    @BeforeTest
    fun setUp() {
        converter = LatinCyrillicImpl(Alphabet.BulgarianIso9)
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
    fun testAlphabet() = runTest { // verified with: https://www.translitteration.com/transliteration/en/bulgarian/iso-9/
            assertEquals( """"
A,a
B,b
V,v
G,g
D,d
E,e
Ž,ž
Z,z
I,i
J,j
K,k
L,l
M,m
N,n
O,o
P.p
R,r
S,s
T,t
U,u
F,f
H,h
C,c
Č,č
Š,š
Ŝ,ŝ
ʺ
ʹ
Û,û
Â,â
""",
                converter.cyrillicToLatin(""""
А,а
Б,б
В,в
Г,г
Д,д
Е,е
Ж,ж
З,з
И,и
Й,й
К,к
Л,л
М,м
Н,н
О,о
П.п
Р,р
С,с
Т,т
У,у
Ф,ф
Х,х
Ц,ц
Ч,ч
Ш,ш
Щ,щ
ъ
ь
Ю,ю
Я,я
"""
                )
            )
        }

    @Test
    fun testAlphabetFromTransliteration() = runTest { // verified with: https://www.translitteration.com/transliteration/en/bulgarian/iso-9/
            assertEquals(""""
aabbvvggddeežžzziijjkkllmmnnoopprrssttuuffhhccččššŝŝûûââ
ʺʺ
ʹʹ
AABBVVGGDDEEŽŽZZIIJJKKLLMMNNOOPPRRSSTTUUFFHHCCČČŠŠŜŜÛÛÂÂ
""",
                converter.cyrillicToLatin(""""
аaбbвvгgдdеeжžзzиiйjкkлlмmнnоoпpрrсsтtуuфfхhцcчčшšщŝюûяâ
ъʺ
ьʹ
АAБBВVГGДDЕEЖŽЗZИIЙJКKЛLМMНNОOПPРRСSТTУUФFХHЦCЧČШŠЩŜЮÛЯÂ
"""
                )
            )
        }
}