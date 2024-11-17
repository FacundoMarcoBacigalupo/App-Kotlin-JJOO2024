package repositories
import com.losPro.aplicaciondearranque.dominio.data.InvalidCredentialsException
import com.losPro.aplicaciondearranque.dominio.data.User


object UserRepository {
    private val users = mutableListOf<User>()

    init {
        users.add(User(1504L, "bbayarri", "ac", "Brian", "Bayarri", 3500000.50, "2022/12/10"))
        users.add(User(2802L, "AHOZ", "lock_password", "Aylen", "Hoz", 200000.50, "2021/01/11"))
        users.add(User(1510L, "Diegote", "@12345", "Diego", "Gonzalez", 120000.0, "2018/04/15"))
    }

    //Validate if user exist and login session
    fun login(nickName:String, password:String): User? {
        return try {
            val user = users.find { it.nickName == nickName && it.password == password }
            if(user == null){
                throw InvalidCredentialsException("Credentials are invalids")
            }
            else{
                user
            }
        }
        catch (e: InvalidCredentialsException){
            println(e.message)
            null
        }
    }

}