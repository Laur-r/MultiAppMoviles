package com.example.multiapp;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AdminUsuariosActivity extends AppCompatActivity {

    ListView listView;
    TextView tvVacio;
    ArrayList<String> itemsMostrados;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlista);

        listView = findViewById(R.id.listView);
        tvVacio = findViewById(R.id.tvVacio);
        itemsMostrados = new ArrayList<>();

        cargarLista();

        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            String eliminado = AdminCrearUserActivity.listaCredenciales.get(position).getUsuario();
            AdminCrearUserActivity.listaCredenciales.remove(position);
            Toast.makeText(this, "'" + eliminado + "' eliminado", Toast.LENGTH_SHORT).show();
            cargarLista();
            return true;
        });
    }

    private void cargarLista() {
        itemsMostrados.clear();

        for (Credencial c : AdminCrearUserActivity.listaCredenciales) {
            itemsMostrados.add("Usuario: " + c.getUsuario());
        }

        if (itemsMostrados.isEmpty()) {
            tvVacio.setVisibility(View.VISIBLE);
            listView.setVisibility(View.GONE);
        } else {
            tvVacio.setVisibility(View.GONE);
            listView.setVisibility(View.VISIBLE);
        }

        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                itemsMostrados);
        listView.setAdapter(adapter);
    }

    public void regresar(View v) { finish(); }
}