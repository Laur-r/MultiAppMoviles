package com.example.multiapp;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AdminCrearUserActivity extends AppCompatActivity {

    static ArrayList<Credencial> listaCredenciales = new ArrayList<>();

    EditText edtUsuario, edtContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admincrear);

        edtUsuario = findViewById(R.id.edtUsuario);
        edtContrasena = findViewById(R.id.edtContrasena);
    }

    public void guardar(View v) {
        String usuario = edtUsuario.getText().toString().trim();
        String contrasena = edtContrasena.getText().toString().trim();

        if (usuario.isEmpty() || contrasena.isEmpty()) {
            Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        for (Credencial c : listaCredenciales) {
            if (c.getUsuario().equals(usuario)) {
                Toast.makeText(this, "Ese usuario ya existe", Toast.LENGTH_SHORT).show();
                return;
            }
        }

        listaCredenciales.add(new Credencial(usuario, contrasena));

        Toast.makeText(this, "Usuario '" + usuario + "' creado", Toast.LENGTH_SHORT).show();
        edtUsuario.setText("");
        edtContrasena.setText("");
    }

    public void regresar(View v) {
        finish();
    }
}