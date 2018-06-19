package DataBase

import DAO.ProdutoDAO
import DAO.UserDAO
import Entity.Produto
import Entity.User
import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [Produto::class, User::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase()
{
    abstract fun produtoDao(): ProdutoDAO;
    abstract fun userDao(): UserDAO;
}