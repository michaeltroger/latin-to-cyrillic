package com.michaeltroger.latintocyrillic.russian

import com.michaeltroger.latintocyrillic.Alphabet
import com.michaeltroger.latintocyrillic.LatinCyrillic
import com.michaeltroger.latintocyrillic.LatinCyrillicImpl
import com.michaeltroger.latintocyrillic.runBlockingTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals


internal class RussianCyrillicToLatinTest {

    private lateinit var converter: LatinCyrillic

    @BeforeTest
    fun setUp() {
        converter = LatinCyrillicImpl(Alphabet.RussianIso9)
    }

    @Test
    fun testEdgeCases() = runBlockingTest {
        assertEquals("", converter.cyrillicToLatin(""))
        assertEquals(".", converter.cyrillicToLatin("."))
        assertEquals(",", converter.cyrillicToLatin(","))
        assertEquals("!", converter.cyrillicToLatin("!"))
        assertEquals("?", converter.cyrillicToLatin("?"))
    }

    @Test
    fun testAlphabet() = runBlockingTest { // verified with: https://www.translitteration.com/transliteration/en/russian/iso-9/
            assertEquals(""""
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
""",
                converter.cyrillicToLatin(
                    """"
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
"""
            ))
        }

    @Test
    fun testAlphabetFromTransliteration() = runBlockingTest { // verified with: https://www.translitteration.com/transliteration/en/russian/iso-9/
            assertEquals(""""
aabbvvggddeeëëžžzziijjkkllmmnnoopprrssttuuffhhccččššŝŝyyûûââʺʺʹʹèè
AABBVVGGDDEEËËŽŽZZIIJJKKLLMMNNOOPPRRSSTTUUFFHHCCČČŠŠŜŜYÛÛÂÂÈÈ
""",
                converter.cyrillicToLatin(
                    """"
аaбbвvгgдdеeёëжžзzиiйjкkлlмmнnоoпpрrсsтtуuфfхhцcчčшšщŝыyюûяâъʺьʹэè
АAБBВVГGДDЕEЁËЖŽЗZИIЙJКKЛLМMНNОOПPРRСSТTУUФFХHЦCЧČШŠЩŜYЮÛЯÂЭÈ
"""
            ))
        }
}