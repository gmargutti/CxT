package DAO

import Entity.Produto
import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE

@Dao interface ProdutoDAO
{
    @Query("SELECT * FROM Produto WHERE Produto.id = :id")
    fun getProduto(id: Int): Produto;

    @Query("select * from Produto")
    fun getProdutoList(): List<Produto>;

    @Insert(onConflict = REPLACE)
    fun insert(p: Produto);

    @Update(onConflict =  REPLACE)
    fun update(p: Produto);

    @Delete
    fun delete(p: Produto);
}