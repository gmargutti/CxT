package CustomApplication

import DataBase.AppDatabase
import Entity.Produto
import RoomMigration.Migration1to2
import android.app.Application
import android.arch.persistence.room.Room

class CustomApp : Application()
{
    companion object {
        private lateinit var context: CustomApp;
        private var dbConnection: AppDatabase? = null;

        fun getDataBaseConnection(): AppDatabase
        {
            if(dbConnection == null)
                dbConnection = Room.databaseBuilder(context, AppDatabase::class.java, "teste2")
                        .allowMainThreadQueries()
                        .addMigrations(Migration1to2())
                        .build();
            return dbConnection!!;
        }

    }
    var listProdutos = ArrayList<Produto>();

    init
    {
        context = this
    }
}