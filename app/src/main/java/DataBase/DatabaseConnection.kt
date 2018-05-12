package DataBase

import android.arch.persistence.room.Room

class DatabaseConnection
{
    companion object {
        private var singleton: AppDatabase? = null;
        fun getDB(): AppDatabase
        {
            if(singleton == null)
                singleton = Room.databaseBuilder(CustomGlobal.context!!, AppDatabase::class.java, "teste2").allowMainThreadQueries().build();
            return singleton!!;
        }
    }
}