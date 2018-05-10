package DataBase

import DAO.ProdutoDAO
import Entity.Produto
import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
@Database(entities = [Produto::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase()
{
    abstract fun produtoDao(): ProdutoDAO;
}