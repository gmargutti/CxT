package Entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import java.io.Serializable
@Entity(tableName = "Produto")
data class Produto(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    @ColumnInfo(name = "nome")
    var nome: String = "",

    @ColumnInfo(name = "descricao")
    var descricao: String = "",

    @ColumnInfo(name = "preco")
    var preco: Double = 0.0,

    @ColumnInfo(name = "quantidade")
    var quantidade: Int = 0,

    @ColumnInfo(name = "dataInicio")
    var dataInicio: String = "",

    @ColumnInfo(name = "dataFim")
    var dataFim: String = "",

    @ColumnInfo(name = "local")
    var local: String = ""
) : Serializable{


    @Ignore
    var viewIndex: Int = -1;
}