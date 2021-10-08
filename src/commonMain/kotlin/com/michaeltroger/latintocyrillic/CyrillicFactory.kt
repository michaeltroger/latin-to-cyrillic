package com.michaeltroger.latintocyrillic

public object CyrillicFactory {

    public fun createConverter(alphabet: Alphabet): Cyrillic = CyrillicImpl(alphabet)
    public fun createConverter(latin: List<String>, cyrillic: List<Char>): Cyrillic = CyrillicImpl(latin = latin, cyrillic = cyrillic)
}