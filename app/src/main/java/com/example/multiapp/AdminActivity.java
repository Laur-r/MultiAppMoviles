package com.example.multiapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
    }

    public void crearUsuario(View v) {
        startActivity(new Intent(this, AdminCrearUserActivity.class));
    }

    public void administrarUsuarios(View v) {
        startActivity(new Intent(this, AdminUsuariosActivity.class));
    }

    public void regresar(View v) {

        finish();
    }
}