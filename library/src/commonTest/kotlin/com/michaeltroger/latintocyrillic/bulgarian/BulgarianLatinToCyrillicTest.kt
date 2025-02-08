package com.michaeltroger.latintocyrillic.bulgarian

import com.michaeltroger.latintocyrillic.Alphabet
import com.michaeltroger.latintocyrillic.LatinCyrillic
import com.michaeltroger.latintocyrillic.LatinCyrillicImpl
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals


internal class BulgarianLatinToCyrillicTest {

    private lateinit var converter: LatinCyrillic

    @BeforeTest
    fun setUp() {
        converter = LatinCyrillicImpl(Alphabet.BulgarianIso9)
    }

    @Test
    fun testEdgeCases() = runTest {
        assertEquals("", converter.latinToCyrillic(""))
        assertEquals(".", converter.latinToCyrillic("."))
        assertEquals(",", converter.latinToCyrillic(","))
        assertEquals("!", converter.latinToCyrillic("!"))
        assertEquals("?", converter.latinToCyrillic("?"))
    }

    @Test
    fun testAlphabet() = runTest { // verified with: https://www.translitteration.com/transliteration/en/bulgarian/iso-9/
            assertEquals(""""
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
""",
                converter.latinToCyrillic(""""
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
"""
                )
            )
        }


    @Test
    fun testAlphabetFromTransliteration() = runTest { // verified with: https://www.translitteration.com/transliteration/en/bulgarian/iso-9/
            assertEquals(""""
ааббввггддеежжззииййккллммннооппррссттууффххццччшшщщююяя
ъъ
ьь
ААББВВГГДДЕЕЖЖЗЗИИЙЙККЛЛММННООППРРССТТУУФФХХЦЦЧЧШШЩЩЮЮЯЯ
""",
                converter.latinToCyrillic(""""
аaбbвvгgдdеeжžзzиiйjкkлlмmнnоoпpрrсsтtуuфfхhцcчčшšщŝюûяâ
ъʺ
ьʹ
АAБBВVГGДDЕEЖŽЗZИIЙJКKЛLМMНNОOПPРRСSТTУUФFХHЦCЧČШŠЩŜЮÛЯÂ
"""
                )
            )
    }
}