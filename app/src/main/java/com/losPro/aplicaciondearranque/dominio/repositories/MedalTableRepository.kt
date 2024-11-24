package repositories
import com.losPro.aplicaciondearranque.dominio.data.Country

object MedalTableRepository {
    private val countries = mutableListOf<Country>()

    init {
        countries.add(
            Country(
                1L,
                     1.toString(),
                "Estados Unidos",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a4/Flag_of_the_United_States.svg/2560px-Flag_of_the_United_States.svg.png",
                35,
                30,
                25
            )
        )

        countries.add(
            Country(
                2L,
                2.toString(),
                "China",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Flag_of_the_People%27s_Republic_of_China.svg/1024px-Flag_of_the_People%27s_Republic_of_China.svg.png",
                32,
                28,
                22
            )
        )

        countries.add(
            Country(
                3L,
                3.toString(),
                "Argentina",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1a/Flag_of_Argentina.svg/2560px-Flag_of_Argentina.svg.png",
                28,
                24,
                20
            )
        )

        countries.add(
            Country(
                4L,
                4.toString(),
                "Alemania",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/b/ba/Flag_of_Germany.svg/640px-Flag_of_Germany.svg.png",
                24,
                20,
                18
            )
        )

        countries.add(
            Country(
                5L,
                5.toString(),
                "Japón",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9e/Flag_of_Japan.svg/1200px-Flag_of_Japan.svg.png",
                22,
                18,
                16
            )
        )

        countries.add(
            Country(
                6L,
                6.toString(),
                "Reino Unido",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/Flag_of_the_United_Kingdom_%281-2%29.svg/1200px-Flag_of_the_United_Kingdom_%281-2%29.svg.png",
                20,
                17,
                15
            )
        )

        countries.add(
            Country(
                7L,
                7.toString(),
                "Francia",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/9/93/Flag_of_France_%281794%E2%80%931815%2C_1830%E2%80%931974%29.svg/1200px-Flag_of_France_%281794%E2%80%931815%2C_1830%E2%80%931974%29.svg.png",
                18,
                15,
                14
            )
        )

        countries.add(
            Country(
                8L,
                8.toString(),
                "Australia",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/8/88/Flag_of_Australia_%28converted%29.svg/1200px-Flag_of_Australia_%28converted%29.svg.png",
                16,
                14,
                12
            )
        )

        countries.add(
            Country(
                9L,
                9.toString(),
                "Italia",
                "https://upload.wikimedia.org/wikipedia/commons/0/03/Flag_of_Italy.svg",
                14,
                12,
                10
            )
        )

        countries.add(
            Country(
                10L,
                10.toString(),
                "Canadá",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Flag_of_Canada_%28Pantone%29.svg/800px-Flag_of_Canada_%28Pantone%29.svg.png",
                12,
                10,
                8
            )
        )
    }


    //Get list of medals sum
    fun get() : Map<Country, Int> {
        val listOfMedalTable = mutableMapOf<Country, Int>()

        countries.forEach { country ->
            val totalMedals = country.goldMedals + country.silverMedals + country.bronzeMedals
            listOfMedalTable[country] = totalMedals
        }

        return listOfMedalTable
    }

}