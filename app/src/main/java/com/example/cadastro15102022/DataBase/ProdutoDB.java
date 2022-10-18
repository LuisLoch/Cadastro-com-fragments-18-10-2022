package com.example.cadastro15102022.DataBase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ListView;

import com.example.cadastro15102022.Entityes.Produto;

import java.util.List;

public class ProdutoDB {
    private DBHelperProdutos db;
    private SQLiteDatabase conexao;

    public ProdutoDB(DBHelperProdutos db){
        this.db=db;
    }

    public void inserirProduto(Produto produto){
        conexao = db.getWritableDatabase();//abre o db
        ContentValues valores = new ContentValues();
        valores.put("nomeProduto", produto.getNomeProduto());
        valores.put("marcaProduto", produto.getMarcaProduto());
        valores.put("quantidadeProduto", produto.getQuantidadeProduto());
        conexao.insertOrThrow("produtos",null, valores);
        conexao.close();
    }

    public void atualizarProdutos(ListView lista){
        lista.invalidateViews();
    }

    public int editarProduto(int id, Produto produto){
        conexao = db.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("nomeProduto", produto.getNomeProduto());
        valores.put("marcaProduto", produto.getMarcaProduto());
        valores.put("quantidadeProduto", produto.getQuantidadeProduto());
        String whereArgs[] = {""+id};
        int count = conexao.update("produtos", valores, "id=?", whereArgs);
        conexao.close();
        return count;
    }

    public void removerProduto(int id){
        conexao = db.getWritableDatabase();
        conexao.delete("produtos","id=?", new String[]{id+""});
    }

    public void listarProdutos(List dados){
        dados.clear();
        conexao = db.getReadableDatabase();
        String names[] = {"id","nomeProduto","marcaProduto","quantidadeProduto"};
        Cursor query = conexao.query("produtos", names, null, null, null, null, "nome");
        while (query.moveToNext()){
            Produto produto = new Produto();
            produto.setId(Integer.parseInt(query.getString(0)));
            produto.setNomeProduto(query.getString(1));
            produto.setMarcaProduto(query.getString(2));
            produto.setQuantidadeProduto(Integer.valueOf(query.getString(3)));
            dados.add(produto);
        }
        conexao.close();
    }
}
