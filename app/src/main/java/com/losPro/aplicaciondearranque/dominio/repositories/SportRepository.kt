package repositories
import com.losPro.aplicaciondearranque.dominio.data.Sport

object SportRepository {
    fun getFootball(): Sport {
        return Sport(
            1L,
            "Futbol",
            4.3,
            "https://img.freepik.com/vector-premium/icono-vectorial-futbol-puede-usarse-conjunto-iconos-juegos-olimpicos_717774-65217.jpg"
        )
    }

    fun getBasketball(): Sport {
        return Sport(
            2L,
            "Basquet",
            4.9,
            "https://static.vecteezy.com/system/resources/previews/015/324/920/non_2x/basketball-cracked-wall-basketball-club-graphic-design-logos-or-icons-illustration-vector.jpg"
        )
    }

    fun getAthletics(): Sport {
        return Sport(
            3L,
            "Atletismo",
            4.7,
            "https://w7.pngwing.com/pngs/316/338/png-transparent-athlete-sport-track-and-field-athletics-athletics-s-text-running-olympic-games.png"
        )
    }

    fun getSwimming(): Sport {
        return Sport(
            4L,
            "Natación",
            4.8,
            "https://w7.pngwing.com/pngs/69/117/png-transparent-laurel-municipal-swimming-pool-logo-west-laurel-swim-club-chicken-logo-text-trademark-logo.png"
        )
    }

    fun getGymnastics(): Sport {
        return Sport(
            5L,
            "Gimnasia",
            4.2,
            "https://w7.pngwing.com/pngs/703/477/png-transparent-artistic-gymnastics-sport-cheer-logo-vertebrate-computer-wallpaper.png"
        )
    }

    fun getCycling(): Sport {
        return Sport(
            6L,
            "Ciclismo",
            3.9,
            "https://w7.pngwing.com/pngs/191/570/png-transparent-cycling-computer-icons-road-bicycle-racing-logo-cycling-blue-text-trademark.png"
        )
    }

    fun getRowing(): Sport {
        return Sport(
            7L,
            "Remo",
            4.1,
            "https://e7.pngegg.com/pngimages/63/910/png-clipart-rowing-olympic-games-sport-rowing-sport-logo.png"
        )
    }

    fun getFencing(): Sport {
        return Sport(
            8L,
            "Esgrima",
            3.7,
            "https://w7.pngwing.com/pngs/806/132/png-transparent-fencing-at-the-summer-olympics-olympic-games-pictogram-espada-laser-text-sport-monochrome.png"
        )
    }

    fun getJudo(): Sport {
        return Sport(
            9L,
            "Judo",
            4.3,
            "https://t4.ftcdn.net/jpg/01/84/82/95/360_F_184829595_4Ogh3DF5md17147Af3fQqNBL706m7T72.jpg"
        )
    }

    fun getTennis(): Sport {
        return Sport(
            10L,
            "Tenis",
            3.5,
            "https://img.freepik.com/vector-premium/tenis-deporte-silueta-logo-icono-ilustracion-marca-identidad_7109-1016.jpg"
        )
    }


}