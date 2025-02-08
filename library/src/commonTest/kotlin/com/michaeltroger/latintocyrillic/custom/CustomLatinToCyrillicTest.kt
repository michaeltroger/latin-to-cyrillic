package com.michaeltroger.latintocyrillic.custom

import com.michaeltroger.latintocyrillic.Alphabet
import com.michaeltroger.latintocyrillic.LatinCyrillicImpl
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith


internal class CustomLatinToCyrillicTest {

    @Test
    fun testEdgeCases() = runTest {
        val converter = LatinCyrillicImpl(latin = listOf("a", "bc"), cyrillic = listOf('Љ', 'Џ'))
        assertEquals("", converter.latinToCyrillic(""))
        assertEquals(".", converter.latinToCyrillic("."))
        assertEquals(",", converter.latinToCyrillic(","))
        assertEquals("!", converter.latinToCyrillic("!"))
        assertEquals("?", converter.latinToCyrillic("?"))
    }

    @Test
    fun testWithTwoLettersInAlphabet() = runTest {
        val converter = LatinCyrillicImpl(latin = listOf("a", "bc"), cyrillic = listOf('Љ', 'Џ'))
        assertEquals("Љ", converter.latinToCyrillic("a"))
        assertEquals("Џ", converter.latinToCyrillic("bc"))
        assertEquals("b", converter.latinToCyrillic("b"))
        assertEquals("c", converter.latinToCyrillic("c"))
    }

    @Test
    fun testWithOneLetterInAlphabet() = runTest {
        val converter = LatinCyrillicImpl(latin = listOf("a"), cyrillic = listOf('Љ'))
        assertEquals("Љ", converter.latinToCyrillic("a"))
        assertEquals("n", converter.latinToCyrillic("n"))
    }

    @Test
    fun testSentences() = runTest {
        val converter = LatinCyrillicImpl(latin = listOf("a", "bc"), cyrillic = listOf('Љ', 'Џ'))
        assertEquals("ЉЏ ;-) nice", converter.latinToCyrillic("abc ;-) nice"))
        assertEquals("ЉЉ ЉЉЉ ЉЉЉЉЉ b b. B b c Џ", converter.latinToCyrillic("aa aaa aaaaa b b. B b c bc"))
    }

    @Test
    fun testExtendingSerbianAlphabetByOneLetter() = runTest {
        val serbianConverter = LatinCyrillicImpl(Alphabet.Serbian)
        val latin = serbianConverter.getLatinAlphabet()
        val cyrillic = serbianConverter.getCyrillicAlphabet()

        val converter = LatinCyrillicImpl(latin = latin + listOf("Dz"), cyrillic = cyrillic.map { it[0] } + listOf('Ѕ'))
        assertEquals(""""
А, а
Б, б
В, в
Г, г
Д, д
Ђ, ђ
Е, е
Ж, ж
З, з
И, и
Ј, ј
К, к
Л, л
Љ, љ
М, м
Н, н
Њ, њ
О, о
П, п
Р, р
С, с
Т, т
Ћ, ћ
У, у
Ф, ф
Х, х
Ц, ц
Ч, ч
Џ, џ
Ш, ш
Ѕ
""",
            converter.latinToCyrillic(
                    """"
A, a
B, b
V, v
G, g
D, d
Đ, đ
E, e
Ž, ž
Z, z
I, i
J, j
K, k
L, l
Lj, lj
M, m
N, n
Nj, nj
O, o
P, p
R, r
S, s
T, t
Ć, ć
U, u
F, f
H, h
C, c
Č, č
Dž, dž
Š, š
Dz
"""
                )
            )
        }

    @Test
    fun testIllegalInputLatinShorter() {
        assertFailsWith<IllegalArgumentException> {
            LatinCyrillicImpl(latin = listOf("a"), cyrillic = listOf('Љ', 'Џ'))
        }
    }

    @Test
    fun testIllegalInputCyrillicShorter() {
        assertFailsWith<IllegalArgumentException> {
            LatinCyrillicImpl(latin = listOf("a", "bc"), cyrillic = listOf('Љ'))
        }
    }

    @Test
    fun testIllegalInputTooManyLatinChars() {
        assertFailsWith<IllegalArgumentException> {
            LatinCyrillicImpl(latin = listOf("abc", "d"), cyrillic = listOf('Љ', 'Џ'))
        }
    }

    @Test
    fun testIllegalInputEmptyLatinChars() {
        assertFailsWith<IllegalArgumentException> {
            LatinCyrillicImpl(latin = listOf("a", ""), cyrillic = listOf('Љ', 'Џ'))
        }
    }

}