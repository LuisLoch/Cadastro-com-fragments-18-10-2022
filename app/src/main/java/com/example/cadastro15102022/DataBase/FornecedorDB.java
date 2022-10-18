package com.example.cadastro15102022.DataBase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ListView;

import com.example.cadastro15102022.Entityes.Fornecedor;

import java.util.List;

public class FornecedorDB {
    private DBHelperFornecedores db;
    private SQLiteDatabase conexao;

    public FornecedorDB(DBHelperFornecedores db){
        this.db=db;
    }

    public void inserirFornecedor(Fornecedor fornecedor){
        conexao = db.getWritableDatabase();//abre o db
        ContentValues valores = new ContentValues();
        valores.put("nomeFornecedor", fornecedor.getNomeFornecedor());
        valores.put("cnpjFornecedor", fornecedor.getCnpjFornecedor());
        valores.put("enderecoFornecedor", String.valueOf(fornecedor.getEnderecoFornecedor()));
        conexao.insertOrThrow("fornecedores",null, valores);
        conexao.close();
    }

    public void atualizarFornecedores(ListView lista){
        lista.invalidateViews();
    }

    public int editarFornecedor(int id, Fornecedor fornecedor){
        conexao = db.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("nomeFornecedor", fornecedor.getNomeFornecedor());
        valores.put("cnpjFornecedor", fornecedor.getCnpjFornecedor());
        valores.put("enderecoFornecedor", String.valueOf(fornecedor.getEnderecoFornecedor()));
        String whereArgs[] = {""+id};
        int count = conexao.update("fornecedores", valores, "id=?", whereArgs);
        conexao.close();
        return count;
    }

    public void removerFornecedor(int id){
        conexao = db.getWritableDatabase();
        conexao.delete("fornecedores","id=?", new String[]{id+""});
    }

    public void listarFornecedores(List dados){
        dados.clear();
        conexao = db.getReadableDatabase();
        String names[] = {"id","nomeFornecedor","cnpjFornecedor","enderecoFornecedor"};
        Cursor query = conexao.query("fornecedores", names, null, null, null, null, "nome");
        while (query.moveToNext()){
            Fornecedor fornecedor = new Fornecedor();
            fornecedor.setId(Integer.parseInt(query.getString(0)));
            fornecedor.setNomeFornecedor(query.getString(1));
            fornecedor.setCnpjFornecedor(query.getString(2));
            fornecedor.setEnderecoFornecedor(query.getString(3));
            dados.add(fornecedor);
        }
        conexao.close();
    }
}
