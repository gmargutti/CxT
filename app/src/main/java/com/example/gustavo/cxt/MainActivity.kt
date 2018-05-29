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
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : CustomActivity() {
    private lateinit var produtosAdapter: ProdutosAdapter;
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
            intent.putExtra("Produto", CustomGlobal.listProdutos[position]);
            startActivityForResult(intent, 0);
        }
        override fun onLongClick(position: Int, v: View?)
        {
            var builder = AlertDialog.Builder(this@MainActivity);
            builder.setTitle("Atenção!");
            builder.setMessage("Isso irá deletar o registro. Deseja prosseguir?");
            builder.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
                ProdutoViewModel.delete(CustomGlobal.listProdutos[position]);
                produtosAdapter.notifyItemRemoved(position);
            });
            builder.setNegativeButton("Cancelar", DialogInterface.OnClickListener { dialog, which ->

            });
            builder.show();
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        updateContext();
        btnNew.setOnClickListener(add_Produto);

        if(CustomGlobal.listProdutos.isEmpty())
        {
            CustomGlobal.listProdutos = ProdutoViewModel.getProdutoList();
        }
        produtosAdapter = ProdutosAdapter(CustomGlobal.listProdutos, this);
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