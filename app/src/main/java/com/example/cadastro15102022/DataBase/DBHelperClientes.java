package com.example.cadastro15102022.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelperClientes extends SQLiteOpenHelper {
    public DBHelperClientes(@Nullable Context context) { super(context, "BancoClientes", null, 1); }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE clientes(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nomeCliente VARCHAR(50)," +
                "cpfCliente VARCHAR(14)," +
                "dataNascCliente DATE)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) { }
}
