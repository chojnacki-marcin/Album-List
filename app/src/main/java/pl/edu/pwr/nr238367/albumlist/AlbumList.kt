package pl.edu.pwr.nr238367.albumlist

import java.util.*

object AlbumList {
    val albumList:ArrayList<Album> = initializeList()
    private fun initializeList(): ArrayList<Album> {
        val albumList = ArrayList<Album>()
        val scanner = Scanner(albumInfo)
        while (scanner.hasNextLine()) {
            val albumName = scanner.nextLine()
            val artist = scanner.nextLine()
            val genre = scanner.nextLine()
            //val album = Album(scanner.nextLine(), scanner.nextLine(), scanner.nextLine())
            val prefix = scanner.next()
            val photoList = ArrayList((1..scanner.nextInt()).map { "$prefix$it" })
            val artists = ArrayList((1..scanner.nextInt()).map {
                val firstName = scanner.next()
                val lastName = scanner.next()
                //skip the rest of the line
                scanner.nextLine()
                val dateScanner = Scanner(scanner.nextLine())
                val birthday = Calendar.getInstance().createDate(dateScanner.nextInt(), dateScanner.nextInt(), dateScanner.nextInt())
                val dayOfDeath = if (dateScanner.hasNextInt()) Calendar.getInstance().createDate(dateScanner.nextInt(), dateScanner.nextInt(), dateScanner.nextInt()) else null
                Person(firstName, lastName, birthday, dayOfDeath)
            })
            albumList.add(Album(albumName, artist, genreFromString(genre), photoList, artists))

        }
        return albumList
    }

    //we use hardcoded values for simplicity
    private val albumInfo = """Enigmatic
Czesław Niemen
ROCK
enigmatic 6
4
Czesław Niemen
16 02 1939 17 01 2004
Zbigniew Namysłowski
09 09 1939
Czesław Bartkowski
19 04 1943
Michał Urbaniak
22 01 1943
Kind of Blue
Miles Davis
JAZZ
blue 9
4
Miles Davis
26 05 1926 28 09 1991
Julian Adderley
15 09 1928 8 08 1975
John Coltrane
23 09 1926 17 07 1967
Bill Evans
16 08 1929 15 09 1980
Emotion
Carly Rae Jepsen
POP
emotion 6
5
Carly Jepsen
21 11 1985
Scooter Braun
18 06 1981
Ariel Rechtshaid
23 03 1979
Carl Falk
17 08 1980
Daniel Nigro
14 05 1982
undun
The Roots
RAP
undun 4
4
Tariq Trotter
3 10 1971
Ahmir Thompson
 20 01 1971
Kirk Douglas
30 09 1973
James Poyser
30 01 1967
Mama's Gun
Erykah Badu
SOUL
mama 4
4
Erica Wright
26 02 1971
James Yancey
7 02 1974 10 02 2006
James Poyser
30 01 1967
Ahmir Thompson
 20 01 1971"""
}


