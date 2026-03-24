package com.example.multiapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    }

    public void abrirAgenda(View w){
        Intent intent = new Intent(this, AgendaActivity1.class);
        startActivity(intent);

    }
    public void abrirCalculadora(View w){
        Intent intent = new Intent(this, CalculadoraActivity.class);
        startActivity(intent);

    }
}
