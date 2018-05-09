package Entity

import java.util.*

class Produto{
    var nome: String = "";
    var descricao: String = "";
    var preco = 0.0;
    var quantidade = 0;
    var dataInicio: Date? = null;
    var dataFim: Date? = null;
    var local: String = "";

    constructor(nome: String, descricao: String, preco: Double, quantidade: Int, dataInicio: Date, dataFim: Date, local: String = ""){
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.local = local;
    }

    constructor()
    {

    }
}