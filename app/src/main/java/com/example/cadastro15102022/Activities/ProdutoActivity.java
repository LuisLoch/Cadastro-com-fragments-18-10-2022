package com.example.cadastro15102022.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.cadastro15102022.Fragments.CadastroFragment_produto;
import com.example.cadastro15102022.Fragments.ListagemFragment_produto;
import com.example.cadastro15102022.R;

public class ProdutoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);
        setResult(80);
        ListagemFragment_produto listagem = new ListagemFragment_produto();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.idFrame_produto, listagem);
        transaction.commit();
    }

    public void telaCadastrarProduto(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.idFrame_produto, new CadastroFragment_produto()).commit();
    }

    public void telaListarProdutos(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.idFrame_produto, new ListagemFragment_produto()).commit();
    }
}