package com.michaeltroger.latintocyrillic

public interface Cyrillic {

    public suspend fun latinToCyrillic(text: String): String
    public suspend fun cyrillicToLatin(text: String): String
    public suspend fun isCyrillic(text: String): Boolean
    public suspend fun getLatinAlphabet(): List<String>
    public suspend fun getCyrillicAlphabet(): List<String>
}
