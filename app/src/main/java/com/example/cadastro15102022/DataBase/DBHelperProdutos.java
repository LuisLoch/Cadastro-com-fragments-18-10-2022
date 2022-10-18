package com.example.cadastro15102022.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelperProdutos extends SQLiteOpenHelper {
    public DBHelperProdutos(@Nullable Context context) { super(context, "BancoProdutos", null, 1); }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE produtos(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nomeProduto VARCHAR(100)," +
                "marcaProduto VARCHAR(50)," +
                "quantidadeProduto INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) { }
}
