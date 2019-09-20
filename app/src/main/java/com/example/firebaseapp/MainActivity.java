package com.example.firebaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    // recuperando a instancia para alteracoes diretos no banco de dados
    private DatabaseReference firebaseReferencia = FirebaseDatabase.getInstance().getReference();

    // referencia ao documento usuario
    private DatabaseReference usuarioReferencia = firebaseReferencia.child("usuarios");
    private  DatabaseReference produtoReferencia = firebaseReferencia.child("produtos");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Usuario usuario = new Usuario();

        usuario.setNome("Elena");
        usuario.setSobrenome("Silva");
        usuario.setIdade(25);
        usuario.setSexo("Feminino");

        // salvando dados via objeto
        //usuarioReferencia.child("003").setValue( usuario );


        Produto produto = new Produto();
        produto.setDescricao("Moto g");
        produto.setCor("preto");
        produto.setFabricante("Motorola");

        produtoReferencia.child("001").setValue( produto );

        // gravando dados na coleção
        //usuarioReferencia.child("002").child("nome").setValue("Dayanne Santos");

        //criando nó firebase e salvando dados
        //firebaseReferencia.child("pontos").setValue("100");

    }
}
