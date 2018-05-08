package com.example.gustavo.cxt

import CustomWatchers.DecimalWatcher
import DAO.ProdutoDAO
import Entity.Produto
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_produtocadastro.*
import java.text.DecimalFormat
import java.text.SimpleDateFormat

class ProdutoCadastroActivity : AppCompatActivity() {
    private val btnVoltar_Click = View.OnClickListener {
        this.finish();
    }
    private val btnAdd_Click = View.OnClickListener {
        var produto = Produto();
        var dateFormatter = SimpleDateFormat("dd/MM/yyyy");
        produto.dataFim = dateFormatter.parse(txtDtFim.text.toString());
        produto.dataInicio = dateFormatter.parse(txtDtInicio.text.toString());
        produto.descricao = txtDescr.text.toString();
        produto.local = txtLocal.text.toString();
        produto.nome = txtNome.text.toString();
        var decimalFormatter = DecimalFormat("#.##");
        decimalFormatter.maximumFractionDigits = 2;
        produto.preco = decimalFormatter.parse(txtPreco.text.toString()).toDouble();
        produto.quantidade = txtQtd.text.toString().toInt();

        ProdutoDAO.insert(produto);
        CustomGlobal.listProdutos.add(produto);
        this.finish();
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produtocadastro)

        btnVoltar.setOnClickListener(btnVoltar_Click)
        btnAdd.setOnClickListener(btnAdd_Click);
        txtPreco.addTextChangedListener(DecimalWatcher());
    }
}
