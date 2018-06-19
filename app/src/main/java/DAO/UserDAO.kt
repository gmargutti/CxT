package DAO

import Entity.User
import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE

@Dao interface UserDAO
{
    @Query("SELECT id, username, password FROM User LIMIT 1")
    fun getUser(): User;

    @Insert(onConflict = REPLACE)
    fun addUser(user: User);

    @Delete
    fun delete(user: User);

    @Update
    fun update(oldUser: User, newUser: User);
}