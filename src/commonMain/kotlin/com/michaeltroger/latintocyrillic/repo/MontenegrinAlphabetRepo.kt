package com.michaeltroger.latintocyrillic.repo

import com.michaeltroger.latintocyrillic.LatinCyrillicAlphabetRepo

@Deprecated("Has cyrillic with 2 letters, not supported by converter")
internal class MontenegrinAlphabetRepo : LatinCyrillicAlphabetRepo() {

    override val latinToCyrillicAlphabet: Map<String, String> by lazy {
        hashMapOf(
                "A" to "А",
                "B" to "Б",
                "V" to "В",
                "G" to "Г",
                "Dž" to "Џ",
                "D" to "Д",
                "Đ" to "Ђ",
                "E" to "Е",
                "Ž" to "Ж",
                "Ź" to "З́", // cyrillic 2 letters - not in unicode
                "Z" to "З",
                "I" to "И",
                "J" to "Ј",
                "K" to "К",
                "Lj" to "Љ",
                "L" to "Л",
                "M" to "М",
                "Nj" to "Њ",
                "N" to "Н",
                "O" to "О",
                "P" to "П",
                "R" to "Р",
                "S" to "С",
                "T" to "Т",
                "Ć" to "Ћ",
                "U" to "У",
                "F" to "Ф",
                "H" to "Х",
                "C" to "Ц",
                "Č" to "Ч",
                "Š" to "Ш",
                "Ś" to "С́", // cyrillic 2 letters - not in unicode
                "a" to "а",
                "b" to "б",
                "v" to "в",
                "g" to "г",
                "dž" to "џ",
                "d" to "д",
                "đ" to "ђ",
                "e" to "е",
                "ž" to "ж",
                "ź" to "з́", // cyrillic 2 letters - not in unicode
                "z" to "з",
                "i" to "и",
                "j" to "ј",
                "k" to "к",
                "lj" to "љ",
                "l" to "л",
                "m" to "м",
                "nj" to "њ",
                "n" to "н",
                "o" to "о",
                "p" to "п",
                "r" to "р",
                "s" to "с",
                "t" to "т",
                "ć" to "ћ",
                "u" to "у",
                "f" to "ф",
                "h" to "х",
                "c" to "ц",
                "č" to "ч",
                "š" to "ш",
                "ś" to "с́" // cyrillic 2 letters - not in unicode
        )
    }
}
