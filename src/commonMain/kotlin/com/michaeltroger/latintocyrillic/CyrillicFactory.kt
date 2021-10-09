package com.michaeltroger.latintocyrillic

public object CyrillicFactory {

    public fun create(alphabet: Alphabet): LatinCyrillic = LatinCyrillicImpl(alphabet)
    public fun create(latin: List<String>, cyrillic: List<Char>): LatinCyrillic = LatinCyrillicImpl(latin = latin, cyrillic = cyrillic)
}