package com.example.cadastro15102022.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import com.example.cadastro15102022.Fragments.CadastroFragment_cliente;
import com.example.cadastro15102022.Fragments.ListagemFragment_cliente;
import com.example.cadastro15102022.R;

public class ClienteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);
        setResult(80);
        ListagemFragment_cliente listagemFragment_cliente = new ListagemFragment_cliente();
        FragmentTransaction transaction =getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.idFrame_cliente, listagemFragment_cliente);
        transaction.commit();
    }

    public void telaCadastrarCliente(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.idFrame_cliente, new CadastroFragment_cliente()).commit();
    }

    public void telaListarClientes(View view){
        getSupportFragmentManager().beginTransaction().replace(R.id.idFrame_cliente, new ListagemFragment_cliente()).commit();
    }
}