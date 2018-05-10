package com.example.gustavo.cxt

import Adapters.ProdutosAdapter
import ViewModel.ProdutoViewModel
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : CustomActivity() {
    companion object {
        private enum class OPERATION(val value: Int)
        {
            Add(0);
        }
    }
    private lateinit var adapter: ProdutosAdapter;
    private val add_Produto: View.OnClickListener = View.OnClickListener {
        val intent = Intent(this, ProdutoCadastroActivity::class.java);
        startActivityForResult(intent, OPERATION.Add.value);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        updateContext();
        setContentView(R.layout.activity_main)

        btnNew.setOnClickListener(add_Produto);

        if(CustomGlobal.listProdutos.isEmpty())
        {
            CustomGlobal.listProdutos = ProdutoViewModel.getProdutoList();
        }
        adapter = ProdutosAdapter(CustomGlobal.listProdutos, this);
        listItems.adapter = adapter;
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == OPERATION.Add.value && resultCode == Activity.RESULT_OK)
            adapter.notifyDataSetChanged();
        super.onActivityResult(requestCode, resultCode, data);
    }
}
