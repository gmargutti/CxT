package com.example.gustavo.cxt

import android.support.v7.app.AppCompatActivity

abstract class CustomActivity : AppCompatActivity()
{
    protected fun updateContext()
    {
        CustomGlobal.context = applicationContext;
    }
}