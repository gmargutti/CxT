package com.example.gustavo.cxt

import Adapters.ProdutosAdapter
import ViewModel.ProdutoViewModel
import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : CustomActivity() {
    private lateinit var adapter: ProdutosAdapter;
    private val add_Produto: View.OnClickListener = View.OnClickListener {
        val intent = Intent(this, ProdutoCadastroActivity::class.java);
        startActivityForResult(intent, 0);
    }
    private val listItem_Click = AdapterView.OnItemClickListener {
        parent, view, position, id ->
        val intent = Intent(this, ProdutoCadastroActivity::class.java);
        intent.putExtra("Produto", CustomGlobal.listProdutos.get(position));
        startActivityForResult(intent, 0);
    }
    private val listItem_LongClick = AdapterView.OnItemLongClickListener { parent, view, position, id ->
        var builder = AlertDialog.Builder(this);
        builder.setTitle("Atenção")
        builder.setMessage("Isso irá deletar o registro selecionado. Deseja prosseguir?");
        builder.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->
            var item = CustomGlobal.listProdutos.get(position);
            ProdutoViewModel.delete(item);
            CustomGlobal.listProdutos.removeAt(item.viewIndex);
            adapter.notifyDataSetChanged();
        });
        builder.setNegativeButton("Cancelar", null);
        builder.show();
        true;
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        updateContext();
        btnNew.setOnClickListener(add_Produto);
        listItems.onItemClickListener = listItem_Click;
        listItems.onItemLongClickListener = listItem_LongClick;

        if(CustomGlobal.listProdutos.isEmpty())
        {
            CustomGlobal.listProdutos = ProdutoViewModel.getProdutoList();
        }
        adapter = ProdutosAdapter(CustomGlobal.listProdutos, this);
        listItems.adapter = adapter;
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(resultCode == Activity.RESULT_OK)
            adapter.notifyDataSetChanged();
        super.onActivityResult(requestCode, resultCode, data);
    }
}