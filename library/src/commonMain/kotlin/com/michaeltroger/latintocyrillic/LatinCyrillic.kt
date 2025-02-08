package com.michaeltroger.latintocyrillic

/**
 * Allows to convert Latin to Cyrillic and vice versa.
 * To create an object use [LatinCyrillicFactory]
 */
public interface LatinCyrillic {

    /**
     * Convert the given text from latin script to cyrillic script
     */
    public suspend fun latinToCyrillic(text: String): String

    /**
     * Convert the given text from cyrillic script to latin script
     */
    public suspend fun cyrillicToLatin(text: String): String

    /**
     * Check if the given text is considered cyrillic
     */
    public suspend fun isCyrillic(text: String): Boolean

    /**
     * The used alphabet in latin script (sorted)
     * One list item represents one letter
     * Is sorted the same way as [getCyrillicAlphabet],
     * that means index 0 of Latin is associated with index 0 of Cyrillic, index 1 with index 1 and so on
     */
    public suspend fun getLatinAlphabet(): List<String>

    /**
     * The used alphabet in cyrillic script (sorted)
     * One list item represents one letter
     * Is sorted the same way as [getLatinAlphabet],
     * that means index 0 of Latin is associated with index 0 of Cyrillic, index 1 with index 1 and so on
     */
    public suspend fun getCyrillicAlphabet(): List<String>
}
