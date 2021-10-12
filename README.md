# Latin To Cyrillic Kotlin Multiplatform Library
## Cyrillic Transliteration
[![CI](https://github.com/michaeltroger/latin-to-cyrillic/actions/workflows/ci.yml/badge.svg)](https://github.com/michaeltroger/latin-to-cyrillic/actions/workflows/ci.yml) [![Maven Central](https://img.shields.io/maven-central/v/com.michaeltroger/latin-to-cyrillic)](https://repo1.maven.org/maven2/com/michaeltroger/)

A library for converting text from Latin script to Cyrillic script and vice versa. Can be compiled for JVM/Android, JavaScript, Desktop Native and iOS.
Simple to use and modern Coroutine based API. Used by the popular [Cyrillic Transliterator Android app](https://github.com/michaeltroger/latintocyrillic-android).

Supported alphabets:
- Serbian Azbuka
- Belarusian (ISO 9:1995)
- Bulgarian (ISO 9:1995)
- Macedonian (ALA-LC)
- Macedonian (ISO 9:1995)
- Russian (ISO 9:1995)
- Ukrainian (ISO 9:1995)
- Custom alphabet (see further down for details)

### Add dependency for your platform:
```
dependencies {
    // Android / Kotlin Multiplatform (specify in commonMain):
    implementation 'com.michaeltroger:latin-to-cyrillic:1.0.0' 
    
    // Java Virtual Machine:
    implementation 'com.michaeltroger:latin-to-cyrillic-jvm:1.0.0'
 
    // JavaScript:
    implementation 'com.michaeltroger:latin-to-cyrillic-js:1.0.0'
    
    // Kotlin Native:
    implementation 'com.michaeltroger:latin-to-cyrillic-native:1.0.0'
}
```
### Usage in Kotlin Android:
```
val latinCyrillic = LatinCyrillicFactory.create(Alphabet.Serbian)
val cyrillic = latinCyrillic.latinToCyrillic("Bolje") // returns "Боље"
val latin = latinCyrillic.cyrillicToLatin("Боље") // returns "Bolje"
```


You can also check whether a text is considered Cyrillic:
```
latinCyrillic.isCyrillic("Bolje") // returns false
latinCyrillic.isCyrillic("Боље") // returns true
```
Furthermore you can print the entire, active conversion table:
```
latinCyrillic.getLatinAlphabet() // returns listOf("A","B","C", ...)
latinCyrillic.getCyrillicAlphabet() // returns listOf("А","Б","Ц", ...)
```

You can make use of the custom alphabet factory to use a fully custom conversion table:
```
LatinCyrillicFactory.create(latin = listOf("A","B","C"), cyrillic = listOf('А','Б','Ц'))
```
The limitation here is that a latin letter may be described by 1 or 2 characters and a cyrillic letter by 1 character.

### Adding new alphabets
You are free to open Pull requests for adding more alphabets, but I ask for your understanding that I only integrate unambiguous conversion tables. E.g. with transcription tables you can only transcript from one script to the other, but not back to the original one! That's why this lib only includes a limited set of transliteration alphabets.

Any new alphabet should be an official standard and allow conversion forth and back. This is mostly only possible for ISO 9:1995 standards. Another limitation coming from the business logic is that Latin letters may have 1 or 2 characters, while Cyrillic letters may only have 1. In doubts please contact me upfront before investing too much time. Anyways you can always use a custom alphabet, so the alphabet you use doesn't necessarilly need to be part of the lib here. 



Author:
[Michael Troger](https://michaeltroger.com)
