package com.example.firebaseapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    // recuperando a instancia para alteracoes diretos no banco de dados
    private DatabaseReference firebaseReferencia = FirebaseDatabase.getInstance().getReference();

    // referencia ao documento usuario
    private DatabaseReference usuarioReferencia = firebaseReferencia.child("usuarios");
    private  DatabaseReference produtoReferencia = firebaseReferencia.child("produtos").child("001");

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

        /*
        Produto produto = new Produto();
        produto.setDescricao("Moto g");
        produto.setCor("preto");
        produto.setFabricante("Motorola");
        produtoReferencia.child("001").setValue( produto );
        */

        //Recuperando Dados da coleção em tempo real
        usuarioReferencia.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Log.i("FIREBASE: ", dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        // gravando dados na coleção
        //usuarioReferencia.child("002").child("nome").setValue("Dayanne Santos");

        //criando nó firebase e salvando dados
        //firebaseReferencia.child("pontos").setValue("100");

    }
}
