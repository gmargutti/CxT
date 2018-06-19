package RoomMigration

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.migration.Migration

class Migration1to2 : Migration(1,2)
{
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("CREATE TABLE User(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                "username TEXT NOT NULL," +
                "password TEXT NOT NULL)");
    }

}