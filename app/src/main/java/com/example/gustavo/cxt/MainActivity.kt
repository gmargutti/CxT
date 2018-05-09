package com.example.gustavo.cxt

import Adapters.ProdutosAdapter
import Entity.Produto
import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        private enum class OPERATION(val value: Int)
        {
            Add(0);
        }
    }
    private var adapter: ProdutosAdapter? = null;
    private val add_Produto: View.OnClickListener = View.OnClickListener {
        val intent = Intent(this, ProdutoCadastroActivity::class.java);
        startActivityForResult(intent, OPERATION.Add.value);
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnNew.setOnClickListener(add_Produto);
        CustomGlobal.listProdutos = ArrayList<Produto>();
        setAdapter();
    }
    private fun setAdapter()
    {
        adapter = ProdutosAdapter(CustomGlobal.listProdutos!!, this);
        listItems.adapter = adapter;
    }

    override fun onDestroy() {
        CustomGlobal.listProdutos = null;
        super.onDestroy();
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == OPERATION.Add.value && resultCode == Activity.RESULT_OK)
            adapter!!.notifyDataSetChanged();
        super.onActivityResult(requestCode, resultCode, data);
    }
}
