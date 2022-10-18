package com.example.cadastro15102022.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.cadastro15102022.Fragments.CadastroFragment_fornecedor;
import com.example.cadastro15102022.Fragments.ListagemFragment_fornecedor;
import com.example.cadastro15102022.R;

public class FornecedorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fornecedor);
        setResult(80);
        ListagemFragment_fornecedor listagemFragment_fornecedor = new ListagemFragment_fornecedor();
        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.idFrame_fornecedor, listagemFragment_fornecedor);
        transaction.commit();
    }

    public void telaCadastrarFornecedor(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.idFrame_fornecedor, new CadastroFragment_fornecedor()).commit();
    }

    public void telaListarFornecedores(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.idFrame_fornecedor, new ListagemFragment_fornecedor()).commit();
    }
}