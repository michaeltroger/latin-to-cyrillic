package com.michaeltroger.latintocyrillic

public object LatinCyrillicFactory {

    /**
     * Use this method to choose one of the existing Latin/Cyrillic alphabets
     * @param alphabet the [Alphabet] to initialize with
     * @return the [LatinCyrillic] object initialized with the chosen alphabet
     */
    public fun create(alphabet: Alphabet): LatinCyrillic = LatinCyrillicImpl(alphabet)

    /**
     * Use this method if you want to specify a custom Latin/Cyrillic alphabet
     * @param latin 1 or 2 characters are allowed to describe a letter
     * @param cyrillic  1 character is allowed to describe a letter
     * Both [latin] and [cyrillic] lists need to be of same size.
     * Index 0 of [latin] is associated with index 0 of [cyrillic], index 1 with index 1 and so on
     * @return the [LatinCyrillic] object initialized with the custom alphabet
     */
    public fun create(latin: List<String>, cyrillic: List<Char>): LatinCyrillic = LatinCyrillicImpl(latin = latin, cyrillic = cyrillic)
}