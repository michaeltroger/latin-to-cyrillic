package com.michaeltroger.latintocyrillic.macedonian.iso9

import com.michaeltroger.latintocyrillic.Alphabet
import com.michaeltroger.latintocyrillic.LatinCyrillic
import com.michaeltroger.latintocyrillic.LatinCyrillicImpl
import com.michaeltroger.latintocyrillic.runBlockingTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals


internal class MacedonianIso9LatinToCyrillicTest {

    private lateinit var converter: LatinCyrillic

    @BeforeTest
    fun setUp() {
        converter = LatinCyrillicImpl(Alphabet.MacedonianIso9)
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
    fun testAlphabet() = runBlockingTest { // verified with: https://www.translitteration.com/transliteration/en/macedonian/iso-9/
            assertEquals(""""
А а
Б б
В в
Г г
Д д
Ѓ ѓ
Е е
Ж ж
З з
Ѕ ѕ
И и
Ј ј
К к
Л л
Љ љ
М м
Н н
Њ њ
О о
П п
Р р
С с
Т т
Ќ ќ
У у
Ф ф
Х х
Ц ц
Ч ч
Џ џ
Ш ш
""",
                converter.latinToCyrillic(
                    """"
A a
B b
V v
G g
D d
Ǵ ǵ
E e
Ž ž
Z z
Ẑ ẑ
I i
J̌ ǰ
K k
L l
L̂ l̂
M m
N n
N̂ n̂
O o
P p
R r
S s
T t
Ḱ ḱ
U u
F f
H h
C c
Č č
D̂ d̂
Š š
"""
            ))
        }

    @Test
    fun testAlphabetFromTransliteration() = runBlockingTest { // verified with: https://www.translitteration.com/transliteration/en/macedonian/iso-9/
            assertEquals(  """"
ааббввггддѓѓеежжззѕѕиијјккллљљммннњњооппррссттќќууффххццччџџшш
ААББВВГГДДЃЃЕЕЖЖЗЗЅЅИИЈЈККЛЛЉЉММННЊЊООППРРССТТЌЌУУФФХХЦЦЧЧЏЏШШ
""",
                converter.latinToCyrillic(
                    """"
аaбbвvгgдdѓǵеeжžзzѕẑиiјǰкkлlљl̂мmнnњn̂оoпpрrсsтtќḱуuфfхhцcчčџd̂шš
АAБBВVГGДDЃǴЕEЖŽЗZЅẐИIЈJ̌КKЛLЉL̂МMНNЊN̂ОOПPРRСSТTЌḰУUФFХHЦCЧČЏD̂ШŠ
"""
            ))
        }

}