package com.michaeltroger.latintocyrillic

public object CyrillicFactory {

    public fun create(alphabet: Alphabet): Cyrillic = CyrillicImpl(alphabet)
    public fun create(latin: List<String>, cyrillic: List<Char>): Cyrillic = CyrillicImpl(latin = latin, cyrillic = cyrillic)
}