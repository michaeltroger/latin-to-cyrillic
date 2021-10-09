package com.michaeltroger.latintocyrillic

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
     * The used alphabet in latin script
     */
    public suspend fun getLatinAlphabet(): List<String>

    /**
     * The used alphabet in cyrillic script
     */
    public suspend fun getCyrillicAlphabet(): List<String>
}
