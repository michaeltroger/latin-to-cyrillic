package com.michaeltroger.latintocyrillic.belarusian

import com.michaeltroger.latintocyrillic.Alphabet
import com.michaeltroger.latintocyrillic.LatinCyrillic
import com.michaeltroger.latintocyrillic.LatinCyrillicImpl
import com.michaeltroger.latintocyrillic.runBlockingTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

internal class BelarusianLatinToCyrillicTest {

    private lateinit var converter: LatinCyrillic

    @BeforeTest
    fun setUp() {
        converter = LatinCyrillicImpl(Alphabet.BelarusianIso9)
    }

    @Test
    fun testEdgeCases() = runBlockingTest {
        assertEquals("", converter.latinToCyrillic(""))
        assertEquals(".", converter.latinToCyrillic("."))
        assertEquals(",", converter.latinToCyrillic(","))
        assertEquals("!", converter.latinToCyrillic("!"))
        assertEquals("?", converter.latinToCyrillic("?"))
    }

    @Test
    fun testAlphabet() = runBlockingTest { // verified with: https://www.translitteration.com/transliteration/en/belarusian/iso-9/
            assertEquals(""""
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
""",
            converter.latinToCyrillic(""""
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
"""
            )
        )
    }

    @Test
    fun testAlphabetFromTransliteration() = runBlockingTest { // verified with: https://www.translitteration.com/transliteration/en/belarusian/iso-9/ difference ǔ and ґ (not standard char), DŽ DZ
            assertEquals(""""
ааббввггдддждждздз
ееёёжжззііййкклл
ммннооппррсс
ттууўўф
фххццччшшыыээююяяьь
ААББВВГГ
ДДДжДжДзДз
ЕЕЁЁЖЖЗЗІІЙЙККЛЛ
ММННООППРРССТТУУЎЎФ
ФХХЦЦЧЧШШЭЭЮЮЯЯ
""",
                converter.latinToCyrillic(""""
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