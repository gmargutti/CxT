package com.example.gustavo.cxt

import Adapters.ProdutosAdapter
import ViewModel.ProdutoViewModel
import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.activity_produtos.*
import CustomApplication.CustomApp
import android.support.v7.app.AppCompatActivity

class ProdutosActivity : AppCompatActivity() {
    private lateinit var produtosAdapter: ProdutosAdapter;
    private lateinit var app: CustomApp;
    private val manager: RecyclerView.LayoutManager = LinearLayoutManager(this);
    private val add_Produto: View.OnClickListener = View.OnClickListener {
        val intent = Intent(this, ProdutoCadastroActivity::class.java);
        startActivityForResult(intent, 0);
    }

    private val recyclerView_ClickListener = object : ProdutosAdapter.OnClickListener
    {
        override fun onClick(position: Int, v: View?)
        {
            val intent = Intent(applicationContext, ProdutoCadastroActivity::class.java);
            intent.putExtra("Produto", app.listProdutos[position]);
            startActivityForResult(intent, 0);
        }
        override fun onLongClick(position: Int, v: View?)
        {
            var builder = AlertDialog.Builder(this@ProdutosActivity);
            builder.setTitle("Atenção!");
            builder.setMessage("Isso irá deletar o registro. Deseja prosseguir?");
            builder.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
                ProdutoViewModel.delete(app.listProdutos[position], app.listProdutos);
                produtosAdapter.notifyItemRemoved(position);
            });
            builder.setNegativeButton("Cancelar", DialogInterface.OnClickListener { dialog, which ->

            });
            builder.show();
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produtos)
        btnNew.setOnClickListener(add_Produto);
        app = application as CustomApp;
        if(app.listProdutos.isEmpty())
        {
            app.listProdutos = ProdutoViewModel.getProdutoList();
        }
        produtosAdapter = ProdutosAdapter(app.listProdutos, this);
        produtosAdapter.setOnItemClickListener(recyclerView_ClickListener);
        listItems.apply {
            setHasFixedSize(false);
            layoutManager = manager;
            adapter = produtosAdapter;
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(resultCode == Activity.RESULT_OK)
            produtosAdapter.notifyDataSetChanged();
        super.onActivityResult(requestCode, resultCode, data);
    }
}