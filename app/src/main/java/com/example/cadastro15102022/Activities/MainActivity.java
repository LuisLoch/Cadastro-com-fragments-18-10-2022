package com.example.cadastro15102022.Activities;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.cadastro15102022.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irParaProdutos(View view){
        Intent intent = new Intent(this, ProdutoActivity.class);
        resultLauncher.launch(intent);
    }

    public void irParaClientes(View view){
        Toast.makeText(getApplicationContext(), "click deu certo", Toast.LENGTH_SHORT).show();
        /*Intent intent = new Intent(this, ClienteActivity.class);
        resultLauncher.launch(intent);*/
    }

    public void irParaFornecedores(View view){
        Toast.makeText(getApplicationContext(), "click deu certo", Toast.LENGTH_SHORT).show();
        /*Intent intent = new Intent(this, FornecedorActivity.class);
        resultLauncher.launch(intent);*/
    }

    ActivityResultLauncher resultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode()==80)
                        Toast.makeText(getApplicationContext(), "Retorno.", Toast.LENGTH_SHORT).show();
                }
            }
    );
}