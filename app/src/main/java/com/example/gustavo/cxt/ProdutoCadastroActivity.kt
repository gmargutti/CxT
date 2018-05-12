package com.example.gustavo.cxt

import CustomListeners.DatePicker
import CustomListeners.DecimalWatcher
import Entity.Produto
import ViewModel.ProdutoViewModel
import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_produtocadastro.*

class ProdutoCadastroActivity : CustomActivity() {
    private var currentProduto = Produto();

    private val btnVoltar_Click = View.OnClickListener {
        this.finish();
    }
    private val btnSave_Click = View.OnClickListener {
        currentProduto.dataFim = txtDtFim.text.toString();
        currentProduto.dataInicio = txtDtInicio.text.toString();
        currentProduto.descricao = txtDescr.text.toString();
        currentProduto.local = txtLocal.text.toString();
        currentProduto.nome = txtNome.text.toString();
        currentProduto.quantidade = ValueParser.getInt(txtQtd.text.toString());
        currentProduto.preco = ValueParser.getDouble(txtPreco.text.toString());

        ProdutoViewModel.insert(currentProduto);

        setResult(Activity.RESULT_OK);
        this.finish();
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        updateContext();
        setContentView(R.layout.activity_produtocadastro)
        //Set listeners
        btnVoltar.setOnClickListener(btnVoltar_Click)
        btnSalvar.setOnClickListener(btnSave_Click);
        txtPreco.addTextChangedListener(DecimalWatcher());

        txtDtFim.setOnClickListener(DatePicker(this));
        txtDtInicio.setOnClickListener(DatePicker(this));

        if(intent.extras != null)
            if(intent.extras.containsKey("Produto"))
                currentProduto = intent.extras["Produto"] as Produto;
        loadActivityValues(currentProduto);
    }

    private fun loadActivityValues(produto: Produto)
    {
        txtDtFim.setText(produto.dataFim);
        txtPreco.setText(ValueParser.getStringValue(produto.preco));
        txtNome.setText(produto.nome);
        txtDescr.setText(produto.descricao);
        txtDtInicio.setText(produto.dataInicio);
        txtLocal.setText(produto.local);
        txtQtd.setText(ValueParser.getStringValue(produto.quantidade));
    }
}
