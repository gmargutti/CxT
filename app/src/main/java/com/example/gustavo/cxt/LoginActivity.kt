package com.example.gustavo.cxt

import CustomApplication.CustomApp
import DAO.UserDAO
import Entity.User
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private val dao: UserDAO = CustomApp.getDataBaseConnection().userDao();
    private val btnLogin_Click = View.OnClickListener {

//      TODO("Check Login - Web Service")
        val user = User();
        user.password = txtPassword.text.toString();
        user.userName = txtUser.text.toString();
        if(validateLogin(user))
        {
            startActivity(Intent(applicationContext, ProdutosActivity::class.java));
            finish();
        }
        else
            Toast.makeText(this, "Combinação inválida de Usuário e Senha!", Toast.LENGTH_SHORT).show();
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener(btnLogin_Click);

//        var user = User();
//        user.userName = "gustavo";
//        user.password = "test@123";
//        dao.addUser(user);
//        dao.delete(user);

        val user = dao.getUser();

        if(user != null)
        {
//          TODO("Check Login - Web Service")
            if(validateLogin(user))
            {
                startActivity(Intent(applicationContext, ProdutosActivity::class.java));
                finish();
            }
        }
    }

    private fun validateLogin(user: User): Boolean
    {
        return user.password.equals(getWSPassword(user.userName));
    }

    private fun getWSPassword(username: String): String
    {
//        TODO("Get Password from desired Username");
        return if(username.equals("gustavo")) "test@123" else "";
    }
}
