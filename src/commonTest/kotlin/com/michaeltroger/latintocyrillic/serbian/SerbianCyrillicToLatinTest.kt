package com.michaeltroger.latintocyrillic.serbian

import com.michaeltroger.latintocyrillic.Alphabet
import com.michaeltroger.latintocyrillic.LatinCyrillic
import com.michaeltroger.latintocyrillic.LatinCyrillicImpl
import com.michaeltroger.latintocyrillic.runBlockingTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals


internal class SerbianCyrillicToLatinTest {

    private lateinit var converter: LatinCyrillic

    @BeforeTest
    fun setUp() {
        converter = LatinCyrillicImpl(Alphabet.Serbian)
    }

    @Test
    fun testEdgeCases() = runBlockingTest {
        assertEquals("", converter.cyrillicToLatin(""))
        assertEquals(".", converter.cyrillicToLatin("."))
        assertEquals(",", converter.cyrillicToLatin(","))
        assertEquals("!", converter.cyrillicToLatin("!"))
        assertEquals("?", converter.cyrillicToLatin("?"))
    }

    @Test
    fun testDoubleLetters() = runBlockingTest {
        assertEquals("Nj", converter.cyrillicToLatin("Њ"))
        assertEquals("nj", converter.cyrillicToLatin("њ"))
        assertEquals("Lj", converter.cyrillicToLatin("Љ"))
        assertEquals("lj", converter.cyrillicToLatin("љ"))
        assertEquals("Dž", converter.cyrillicToLatin("Џ"))
        assertEquals("dž", converter.cyrillicToLatin("џ"))
    }

    @Test
    fun testSingleLetters() = runBlockingTest {
        assertEquals("N", converter.cyrillicToLatin("Н"))
        assertEquals("n", converter.cyrillicToLatin("н"))
        assertEquals("L", converter.cyrillicToLatin("Л"))
        assertEquals("l", converter.cyrillicToLatin("л"))
        assertEquals("D", converter.cyrillicToLatin("Д"))
        assertEquals("d", converter.cyrillicToLatin("д"))
        assertEquals("Đ", converter.cyrillicToLatin("Ђ"))
        assertEquals("đ", converter.cyrillicToLatin("đ"))
        assertEquals("Ć", converter.cyrillicToLatin("Ć"))
        assertEquals("ć", converter.cyrillicToLatin("ć"))
    }

    @Test
    fun testSentences() = runBlockingTest { // from http://www.rts.rs
            assertEquals("Procenjena vrednost fabrike je veća od 514 miliona dinara (4.373.000 evra), a kako je ponuda manja od 50 odsto procenjene vrednosti, saglasnost za prodaju dao je odbor poverilaca.",
                converter.cyrillicToLatin(
                    "Процењена вредност фабрике је већа од 514 милиона динара (4.373.000 евра), а како је понуда мања од 50 одсто процењене вредности, сагласност за продају дао је одбор поверилаца."))

            assertEquals(""""Sramno! Izuzetno loše izdanje u odbrani. Sramota me je kako smo odigrali", rekao je vidno iznervirani Meloun posle meča.
Posle tri početna trijumfa, Nagetsi su izgubili drugi uzastopni meč, a Pelikasnima je to bila prva pobda u sezoni.
"U timu imamo velike 'govornike'. Svi pričaju o nekim visokim ciljevima i šampionskim ambicijama, ali to je sra.. Nemojte da pričate, pokažite to na terenu", rekao je Meloun.
Sredinom poslednje četvrtine trener Nagetsa je u jednom trenutku zamenio čak četiri igrača.
"Igrači sa klupe su imali bolji pristup, više su se borili. Moramo da nađemo način da i starteri igraju jednako agresivno, pošto za sada to definitivno ne čine", završio je Meloun.
Naredni meč Denver igra u Orlandu 3. novembra.""",
                converter.cyrillicToLatin(
""""Срамно! Изузетно лоше издање у одбрани. Срамота ме је како смо одиграли", рекао је видно изнервирани Мелоун после меча.
После три почетна тријумфа, Нагетси су изгубили други узастопни меч, а Пеликаснима је то била прва побда у сезони.
"У тиму имамо велике 'говорнике'. Сви причају о неким високим циљевима и шампионским амбицијама, али то је сра.. Немојте да причате, покажите то на терену", рекао је Мелоун.
Средином последње четвртине тренер Нагетса је у једном тренутку заменио чак четири играча.
"Играчи са клупе су имали бољи приступ, више су се борили. Морамо да нађемо начин да и стартери играју једнако агресивно, пошто за сада то дефинитивно не чине", завршио је Мелоун.
Наредни меч Денвер игра у Орланду 3. новембра."""))

        }

    @Test
    fun testAlphabetFromWiki() = runBlockingTest { // source: https://hr.wikipedia.org/wiki/%C4%86irilica verified with https://transliteration.eki.ee and microsoft transliteration tool and https://www.loc.gov/catdir/cpso/roman.html
            assertEquals(""""
A, a
B, b
V, v
G, g
D, d
Đ, đ
E, e
Ž, ž
Z, z
I, i
J, j
K, k
L, l
Lj, lj
M, m
N, n
Nj, nj
O, o
P, p
R, r
S, s
T, t
Ć, ć
U, u
F, f
H, h
C, c
Č, č
Dž, dž
Š, š
Ѕ
""",
                converter.cyrillicToLatin(
""""
А, а
Б, б
В, в
Г, г
Д, д
Ђ, ђ
Е, е
Ж, ж
З, з
И, и
Ј, ј
К, к
Л, л
Љ, љ
М, м
Н, н
Њ, њ
О, о
П, п
Р, р
С, с
Т, т
Ћ, ћ
У, у
Ф, ф
Х, х
Ц, ц
Ч, ч
Џ, џ
Ш, ш
Ѕ
"""  // the last is macedonian char - should be ignored
            ))
        }

    @Test
    fun testAlphabetFromAlaLc() = runBlockingTest { // source: https://hr.wikipedia.org/wiki/%C4%86irilica verified with https://transliteration.eki.ee and microsoft transliteration tool and https://www.loc.gov/catdir/cpso/roman.html
            assertEquals(""""
A  a
B  b
V  v
G  g
D  d
Đ  đ
E  e
Ž  ž
Z  z
I  i
J  j
K  k
L  l
Lj  lj
M  m
N  n
Nj  nj
O  o
P  p
R  r
S  s
T  t
Ć  ć
U  u
F  f
H  h
C  c
Č  č
Dž  dž
Š  š
""",
                converter.cyrillicToLatin(
                    """"
А  а
Б  б
В  в
Г  г
Д  д
Ђ  ђ
Е  е
Ж  ж
З  з
И  и
Ј  ј
К  к
Л  л
Љ  љ
М  м
Н  н
Њ  њ
О  о
П  п
Р  р
С  с
Т  т
Ћ  ћ
У  у
Ф  ф
Х  х
Ц  ц
Ч  ч
Џ  џ
Ш  ш
"""
            ))
        }
    }
