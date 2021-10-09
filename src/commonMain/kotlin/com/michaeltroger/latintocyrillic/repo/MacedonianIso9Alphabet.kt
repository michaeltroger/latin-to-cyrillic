package com.michaeltroger.latintocyrillic.repo

import com.michaeltroger.latintocyrillic.LatinCyrillicAlphabet


internal class MacedonianIso9Alphabet : LatinCyrillicAlphabet() {

    override val latinToCyrillicAlphabet: Map<String, String> by lazy {
        hashMapOf(
                "A" to "А",
                "B" to "Б",
                "V" to "В",
                "G" to "Г",
                "D" to "Д",
                "Ǵ" to "Ѓ",
                "E" to "Е",
                "Ž" to "Ж",
                "Z" to "З",
                "Ẑ" to "Ѕ",
                "I" to "И",
                "J̌" to "Ј", // latin 2 letters - not part of unicode
                "K" to "К",
                "L" to "Л",
                "L̂" to "Љ", // latin 2 letters - not part of unicode
                "M" to "М",
                "N" to "Н",
                "N̂" to "Њ",  // latin 2 letters - not part of unicode
                "O" to "О",
                "P" to "П",
                "R" to "Р",
                "S" to "С",
                "T" to "Т",
                "Ḱ" to "Ќ",
                "U" to "У",
                "F" to "Ф",
                "H" to "Х",
                "C" to "Ц",
                "Č" to "Ч",
                "D̂" to "Џ", // latin 2 letters - not part of unicode
                "Š" to "Ш",
                "a" to "а",
                "b" to "б",
                "v" to "в",
                "g" to "г",
                "d" to "д",
                "ǵ" to "ѓ",
                "e" to "е",
                "ž" to "ж",
                "z" to "з",
                "ẑ" to "ѕ",
                "i" to "и",
                "ǰ" to "ј",
                "k" to "к",
                "l" to "л",
                "l̂" to "љ", // latin 2 letters - not part of unicode
                "m" to "м",
                "n" to "н",
                "n̂" to "њ", // latin 2 letters - not part of unicode
                "o" to "о",
                "p" to "п",
                "r" to "р",
                "s" to "с",
                "t" to "т",
                "ḱ" to "ќ",
                "u" to "у",
                "f" to "ф",
                "h" to "х",
                "c" to "ц",
                "č" to "ч",
                "d̂" to "џ", // latin 2 letters - not part of unicode
                "š" to "ш"
        )
    }
}
