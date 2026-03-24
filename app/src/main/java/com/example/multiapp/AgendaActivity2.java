package com.example.multiapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AgendaActivity2 extends AppCompatActivity {

    CheckBox cbDeporte, cbMusica, cbCine, cbArte, cbLectura, cbViajes, cbCocina, cbTecnologia, cbModa, cbFotografia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_agenda2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cbDeporte = findViewById(R.id.cbDeporte);
        cbMusica = findViewById(R.id.cbMusica);
        cbCine = findViewById(R.id.cbCine);
        cbArte = findViewById(R.id.cbArte);
        cbLectura = findViewById(R.id.cbLectura);
        cbViajes = findViewById(R.id.cbViajes);
        cbCocina = findViewById(R.id.cbCocina);
        cbTecnologia = findViewById(R.id.cbTecnologia);
        cbModa = findViewById(R.id.cbModa);
        cbFotografia = findViewById(R.id.cbFotografia);
    }

    public void preferencias(View v) {
        AgendaActivity1.usuarioTemp.setIntDeporte(cbDeporte.isChecked());
        AgendaActivity1.usuarioTemp.setIntMusica(cbMusica.isChecked());
        AgendaActivity1.usuarioTemp.setIntCine(cbCine.isChecked());
        AgendaActivity1.usuarioTemp.setIntArte(cbArte.isChecked());
        AgendaActivity1.usuarioTemp.setIntLectura(cbLectura.isChecked());
        AgendaActivity1.usuarioTemp.setIntViajes(cbViajes.isChecked());
        AgendaActivity1.usuarioTemp.setIntCocina(cbCocina.isChecked());
        AgendaActivity1.usuarioTemp.setIntTecnologia(cbTecnologia.isChecked());
        AgendaActivity1.usuarioTemp.setIntModa(cbModa.isChecked());
        AgendaActivity1.usuarioTemp.setIntFotografia(cbFotografia.isChecked());

        startActivity(new Intent(this, AgendaActivity3.class));
    }

    public void regresar(View v) {
        finish();
    }
}