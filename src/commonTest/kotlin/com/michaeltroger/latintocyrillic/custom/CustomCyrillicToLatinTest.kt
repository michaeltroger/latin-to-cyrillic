package com.michaeltroger.latintocyrillic.custom

import com.michaeltroger.latintocyrillic.Alphabet
import com.michaeltroger.latintocyrillic.LatinCyrillicImpl
import com.michaeltroger.latintocyrillic.runBlockingTest
import kotlin.test.Test
import kotlin.test.assertEquals


internal class CustomCyrillicToLatinTest {

    @Test
    fun testEdgeCases() = runBlockingTest {
        val converter = LatinCyrillicImpl(latin = listOf("a", "bc"), cyrillic = listOf('Љ', 'Џ'))
        assertEquals("", converter.cyrillicToLatin(""))
        assertEquals(".", converter.cyrillicToLatin("."))
        assertEquals(",", converter.cyrillicToLatin(","))
        assertEquals("!", converter.cyrillicToLatin("!"))
        assertEquals("?", converter.cyrillicToLatin("?"))
    }

    @Test
    fun testWithTwoLettersInAlphabet() = runBlockingTest {
        val converter = LatinCyrillicImpl(latin = listOf("a", "bc"), cyrillic = listOf('Љ', 'Џ'))
        assertEquals("a", converter.cyrillicToLatin("Љ"))
        assertEquals("bc", converter.cyrillicToLatin("Џ"))
        assertEquals("b", converter.cyrillicToLatin("b"))
        assertEquals("c", converter.cyrillicToLatin("c"))
    }

    @Test
    fun testWithOneLetterInAlphabet() = runBlockingTest {
        val converter = LatinCyrillicImpl(latin = listOf("a"), cyrillic = listOf('Љ'))
        assertEquals("a", converter.cyrillicToLatin("Љ"))
        assertEquals("n", converter.cyrillicToLatin("n"))
    }

    @Test
    fun testSentences() = runBlockingTest {
        val converter = LatinCyrillicImpl(latin = listOf("a", "bc"), cyrillic = listOf('Љ', 'Џ'))
        assertEquals("abc ;-) nice", converter.cyrillicToLatin("ЉЏ ;-) nice"))
        assertEquals("aa aaa aaaaa b b. B b c bc", converter.cyrillicToLatin("ЉЉ ЉЉЉ ЉЉЉЉЉ b b. B b c Џ"))
    }

    @Test
    fun testExtendingSerbianAlphabetByOneLetter() = runBlockingTest {
        val serbianConverter = LatinCyrillicImpl(Alphabet.Serbian)
        val latin = serbianConverter.getLatinAlphabet()
        val cyrillic = serbianConverter.getCyrillicAlphabet()

        val converter = LatinCyrillicImpl(latin = latin + listOf("Dz"), cyrillic = cyrillic.map { it[0] } + listOf('Ѕ'))
            assertEquals(""""
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
""",
                converter.cyrillicToLatin(""""
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
"""
                )
            )
        }
    }
