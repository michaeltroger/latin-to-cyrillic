package com.michaeltroger.latintocyrillic.russian

import com.michaeltroger.latintocyrillic.Alphabet
import com.michaeltroger.latintocyrillic.LatinCyrillic
import com.michaeltroger.latintocyrillic.LatinCyrillicImpl
import kotlinx.coroutines.test.runTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

internal class RussianLatinToCyrillicTest {

    private lateinit var converter: LatinCyrillic

    @BeforeTest
    fun setUp() {
        converter = LatinCyrillicImpl(Alphabet.RussianIso9)
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
    fun testAlphabet() = runTest { // verified with: https://www.translitteration.com/transliteration/en/russian/iso-9/
            assertEquals(""""
Аа
Бб
Вв
Гг
Дд
Ее
Ёё
Жж
Зз
Ии
Йй
Кк
Лл
Мм
Нн
Оо
Пп
Рр
Сс
Тт
Уу
Фф
Хх
Цц
Чч
Шш
Щщ
ъ
ы
ь
Ээ
Юю
Яя
""",
                converter.latinToCyrillic(
                    """"
Aa
Bb
Vv
Gg
Dd
Ee
Ëë
Žž
Zz
Ii
Jj
Kk
Ll
Mm
Nn
Oo
Pp
Rr
Ss
Tt
Uu
Ff
Hh
Cc
Čč
Šš
Ŝŝ
ʺ
y
ʹ
Èè
Ûû
Ââ
"""
            ))
        }

    @Test
    fun testAlphabetFromTransliteration() = runTest { // verified with: https://www.translitteration.com/transliteration/en/russian/iso-9/
            assertEquals(""""
ааббввггддееёёжжззииййкклл
ммннооппррссттууфф
ххццччшшщщ
ыыююяя
ъъььээ
ААББВВГГДДЕЕЁЁЖЖЗЗИИЙЙККЛЛ
ММННООППРРССТТУУФФ
ХХЦЦЧЧШШЩЩЮЮЯЯ
ЭЭ
ъ ь
""",
                converter.latinToCyrillic(
                    """"
aabbvvggddeeëëžžzziijjkkll
mmnnoopprrssttuuff
hhccččššŝŝ
yyûûââ
ʺʺʹʹèè
AABBVVGGDDEEËËŽŽZZIIJJKKLL
MMNNOOPPRRSSTTUUFF
HHCCČČŠŠŜŜÛÛÂÂ
ÈÈ
ʺ ʹ
"""
            ))
        }

}