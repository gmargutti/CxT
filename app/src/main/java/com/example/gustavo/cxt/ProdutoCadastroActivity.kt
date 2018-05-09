package com.example.gustavo.cxt

import CustomWatchers.DecimalWatcher
import DAO.ProdutoDAO
import Entity.Produto
import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_produtocadastro.*

class ProdutoCadastroActivity : AppCompatActivity() {
    private val btnVoltar_Click = View.OnClickListener {
        this.finish();
    }
    private val btnAdd_Click = View.OnClickListener {
        var produto = Produto();
        produto.dataFim = ValueParser.getDate(txtDtFim.text.toString());
        produto.dataInicio = ValueParser.getDate(txtDtInicio.text.toString());
        produto.descricao = txtDescr.text.toString();
        produto.local = txtLocal.text.toString();
        produto.nome = txtNome.text.toString();
        produto.quantidade = ValueParser.getInt(txtQtd.text.toString());
        produto.preco = ValueParser.getDouble(txtPreco.text.toString());
        ProdutoDAO.insert(produto);
        CustomGlobal.listProdutos?.add(produto);

        setResult(Activity.RESULT_OK);
        this.finish();
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produtocadastro)
        //Set listeners
        btnVoltar.setOnClickListener(btnVoltar_Click)
        btnAdd.setOnClickListener(btnAdd_Click);
        txtPreco.addTextChangedListener(DecimalWatcher());
    }
}
