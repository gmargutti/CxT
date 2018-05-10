package com.example.gustavo.cxt

import DataBase.AppDatabase
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

abstract class CustomActivity : AppCompatActivity()
{
    protected fun updateContext()
    {
        CustomGlobal.context = applicationContext;
    }
}