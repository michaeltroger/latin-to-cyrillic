package com.michaeltroger.latintocyrillic.repo

import com.michaeltroger.latintocyrillic.LatinCyrillicAlphabetRepo


internal class BulgarianIso9AlphabetRepo : LatinCyrillicAlphabetRepo() {

    override val latinToCyrillicAlphabet: Map<String, String> by lazy {
        hashMapOf(
                "A" to "А",
                "B" to "Б",
                "V" to "В",
                "G" to "Г",
                "D" to "Д",
                "E" to "Е",
                "Ž" to "Ж",
                "Z" to "З",
                "I" to "И",
                "J" to "Й",
                "K" to "К",
                "L" to "Л",
                "M" to "М",
                "N" to "Н",
                "O" to "О",
                "P" to "П",
                "R" to "Р",
                "S" to "С",
                "T" to "Т",
                "U" to "У",
                "F" to "Ф",
                "H" to "Х",
                "C" to "Ц",
                "Č" to "Ч",
                "Š" to "Ш",
                "Ŝ" to "Щ",
                "Û" to "Ю",
                "Â" to "Я",
                "a" to "а",
                "b" to "б",
                "v" to "в",
                "g" to "г",
                "d" to "д",
                "e" to "е",
                "ž" to "ж",
                "z" to "з",
                "i" to "и",
                "j" to "й",
                "k" to "к",
                "l" to "л",
                "m" to "м",
                "n" to "н",
                "o" to "о",
                "p" to "п",
                "r" to "р",
                "s" to "с",
                "t" to "т",
                "u" to "у",
                "f" to "ф",
                "h" to "х",
                "c" to "ц",
                "č" to "ч",
                "š" to "ш",
                "ŝ" to "щ",
                "û" to "ю",
                "â" to "я",
                "ʹ" to "ь",
                "ʺ" to "ъ"
        )
    }
}
