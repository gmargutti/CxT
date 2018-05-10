package Entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import java.util.*
@Entity(tableName = "Produto")
class Produto{
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0;

    @ColumnInfo(name = "nome")
    var nome: String = "";

    @ColumnInfo(name = "descricao")
    var descricao: String = "";

    @ColumnInfo(name = "preco")
    var preco = 0.0;

    @ColumnInfo(name = "quantidade")
    var quantidade = 0;

    @ColumnInfo(name = "dataInicio")
    var dataInicio: String = "";

    @ColumnInfo(name = "dataFim")
    var dataFim: String = "";

    @ColumnInfo(name = "local")
    var local: String = "";

    @Ignore
    constructor(nome: String, descricao: String, preco: Double, quantidade: Int, dataInicio: String, dataFim: String, local: String = ""){
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