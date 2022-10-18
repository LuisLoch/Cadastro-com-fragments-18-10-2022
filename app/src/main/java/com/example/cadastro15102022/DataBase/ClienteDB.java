package com.example.cadastro15102022.DataBase;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ListView;

import com.example.cadastro15102022.Entityes.Cliente;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ClienteDB {
    private DBHelperClientes db;
    private SQLiteDatabase conexao;

    public ClienteDB(DBHelperClientes db){
        this.db=db;
    }

    public void inserirCliente(Cliente cliente){
        conexao = db.getWritableDatabase();//abre o db
        ContentValues valores = new ContentValues();
        valores.put("nomeCliente", cliente.getNomeCliente());
        valores.put("cpfCliente", cliente.getCpfCliente());
        valores.put("dataNascCliente", String.valueOf(cliente.getDataNascCliente()));
        conexao.insertOrThrow("clientes",null, valores);
        conexao.close();
    }

    public void atualizarClientes(ListView lista){
        lista.invalidateViews();
    }

    public int editarCliente(int id, Cliente cliente){
        conexao = db.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("nomeCliente", cliente.getNomeCliente());
        valores.put("cpfCliente", cliente.getCpfCliente());
        valores.put("dataNascCliente", String.valueOf(cliente.getDataNascCliente()));
        String whereArgs[] = {""+id};
        int count = conexao.update("clientes", valores, "id=?", whereArgs);
        conexao.close();
        return count;
    }

    public void removerCliente(int id){
        conexao = db.getWritableDatabase();
        conexao.delete("clientes","id=?", new String[]{id+""});
    }

    public void listarClientes(List dados){
        dados.clear();
        conexao = db.getReadableDatabase();
        String names[] = {"id","nomeCliente","cpfCliente","dataNascCliente"};
        Cursor query = conexao.query("clientes", names, null, null, null, null, "nome");
        while (query.moveToNext()){
            Cliente cliente = new Cliente();
            cliente.setId(Integer.parseInt(query.getString(0)));
            cliente.setNomeCliente(query.getString(1));
            cliente.setCpfCliente(query.getString(2));
            String dataString = query.getString(3);
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
            Date data = null;
            try {
                data = format.parse(dataString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            cliente.setDataNascCliente(data);
            dados.add(cliente);
        }
        conexao.close();
    }
}
