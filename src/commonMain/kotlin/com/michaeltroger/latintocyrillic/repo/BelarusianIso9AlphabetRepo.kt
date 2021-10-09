package com.michaeltroger.latintocyrillic.repo

import com.michaeltroger.latintocyrillic.LatinCyrillicAlphabetRepo


internal class BelarusianIso9AlphabetRepo : LatinCyrillicAlphabetRepo() {

    override val latinToCyrillicAlphabet: Map<String, String> by lazy {
        hashMapOf(
                "A" to "А",
                "B" to "Б",
                "V" to "В",
                "G" to "Г",
                "D" to "Д",
                "E" to "Е",
                "Ë" to "Ё",
                "Ž" to "Ж",
                "Z" to "З",
                "Ì" to "І",
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
                "Ŭ" to "Ў",
                "F" to "Ф",
                "H" to "Х",
                "C" to "Ц",
                "Č" to "Ч",
                "Š" to "Ш",
                "È" to "Э",
                "Û" to "Ю",
                "Â" to "Я",
                "a" to "а",
                "b" to "б",
                "v" to "в",
                "g" to "г",
                "d" to "д",
                "e" to "е",
                "ë" to "ё",
                "ž" to "ж",
                "z" to "з",
                "ì" to "і",
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
                "ŭ" to "ў",
                "f" to "ф",
                "h" to "х",
                "c" to "ц",
                "č" to "ч",
                "š" to "ш",
                "y" to "ы",
                "è" to "э",
                "û" to "ю",
                "â" to "я",
                "ʹ" to "ь"
        )
    }
}