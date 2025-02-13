package com.michaeltroger.latintocyrillic.belarusian

import com.michaeltroger.latintocyrillic.Alphabet
import com.michaeltroger.latintocyrillic.LatinCyrillic
import com.michaeltroger.latintocyrillic.LatinCyrillicImpl
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

internal class BelarusianCyrillicToLatinTest {

    private lateinit var converter: LatinCyrillic

    @BeforeTest
    fun setUp() {
        converter = LatinCyrillicImpl(Alphabet.BelarusianIso9)
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
    fun testAlphabet() = runTest { // verified with: https://www.translitteration.com/transliteration/en/belarusian/iso-9/ only difference ǔ
        assertEquals(""""
A   a
B   b
V   v
G   g
D   d
E   e
Ë   ë
Ž   ž
Z   z
Ì   ì
J   j
K   k
L   l
M   m
N   n
O   o
P   p
R   r
S   s
T   t
U   u
Ŭ   ŭ
F   f
H   h
C   c
Č   č
Š   š
   y
   ʹ
È   è
Û   û
Â   â
ʼ
""",
            converter.cyrillicToLatin(""""
А   а
Б   б
В   в
Г   г
Д   д
Е   е
Ё   ё
Ж   ж
З   з
І   і
Й   й
К   к
Л   л
М   м
Н   н
О   о
П   п
Р   р
С   с
Т   т
У   у
Ў   ў
Ф   ф
Х   х
Ц   ц
Ч   ч
Ш   ш
   ы
   ь
Э   э
Ю   ю
Я   я
ʼ
"""
            )
        )
    }

    @Test
    fun testAlphabetFromTransliteration() = runTest { // verified with: https://www.translitteration.com/transliteration/en/belarusian/iso-9/ difference ǔ and ґ (not standard char), DŽ DZ
            assertEquals(""""
aabbvvggdddždždzdz
eeëëžžzzììjjkkll
mmnnoopprrss
ttuuŭŭf
fhhccččššyyèèûûââʹʹ
AABBVVGG
DDDžDžDzDz
EEËËŽŽZZÌÌJJKKLL
MMNNOOPPRRSSTTUUŬŬF
FHHCCČČŠŠÈÈÛÛÂÂ
""",
            converter.cyrillicToLatin(""""
аaбbвvгgдdджdžдзdz
еeёëжžзzіìйjкkлl
мmнnоoпpрrсs
тtуuўŭф
fхhцcчčшšыyэèюûяâьʹ
АAБBВVГG
ДDДжDžДзDz
ЕEЁËЖŽЗZІÌЙJКKЛL
МMНNОOПPРRСSТTУUЎŬФ
FХHЦCЧČШŠЭÈЮÛЯÂ
"""
            )
        )
    }

}