package com.example.multiapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AgendaActivity3 extends AppCompatActivity {

    CheckBox cbCinePref, cbConciertos, cbRestaurantes, cbTeatro, cbNaturaleza, cbVideojuegos, cbCompras, cbFestivales,  cbMuseos, cbDeportesPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_agenda3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cbCinePref     = findViewById(R.id.cbCinePref);
        cbConciertos   = findViewById(R.id.cbConciertos);
        cbRestaurantes = findViewById(R.id.cbRestaurantes);
        cbTeatro       = findViewById(R.id.cbTeatro);
        cbNaturaleza   = findViewById(R.id.cbNaturaleza);
        cbVideojuegos  = findViewById(R.id.cbVideojuegos);
        cbCompras      = findViewById(R.id.cbCompras);
        cbFestivales   = findViewById(R.id.cbFestivales);
        cbMuseos       = findViewById(R.id.cbMuseos);
        cbDeportesPref = findViewById(R.id.cbDeportesPref);

        if (AgendaActivity1.usuarioTemp != null) {
            cbCinePref.setChecked(AgendaActivity1.usuarioTemp.isPrefCine());
            cbConciertos.setChecked(AgendaActivity1.usuarioTemp.isPrefConciertos());
            cbRestaurantes.setChecked(AgendaActivity1.usuarioTemp.isPrefRestaurantes());
            cbTeatro.setChecked(AgendaActivity1.usuarioTemp.isPrefTeatro());
            cbNaturaleza.setChecked(AgendaActivity1.usuarioTemp.isPrefNaturaleza());
            cbVideojuegos.setChecked(AgendaActivity1.usuarioTemp.isPrefVideojuegos());
            cbCompras.setChecked(AgendaActivity1.usuarioTemp.isPrefCompras());
            cbFestivales.setChecked(AgendaActivity1.usuarioTemp.isPrefFestivales());
            cbMuseos.setChecked(AgendaActivity1.usuarioTemp.isPrefMuseos());
            cbDeportesPref.setChecked(AgendaActivity1.usuarioTemp.isPrefDeportes());
        }
    }

    public void guardar(View v) {
        AgendaActivity1.usuarioTemp.setPrefCine(cbCinePref.isChecked());
        AgendaActivity1.usuarioTemp.setPrefConciertos(cbConciertos.isChecked());
        AgendaActivity1.usuarioTemp.setPrefRestaurantes(cbRestaurantes.isChecked());
        AgendaActivity1.usuarioTemp.setPrefTeatro(cbTeatro.isChecked());
        AgendaActivity1.usuarioTemp.setPrefNaturaleza(cbNaturaleza.isChecked());
        AgendaActivity1.usuarioTemp.setPrefVideojuegos(cbVideojuegos.isChecked());
        AgendaActivity1.usuarioTemp.setPrefCompras(cbCompras.isChecked());
        AgendaActivity1.usuarioTemp.setPrefFestivales(cbFestivales.isChecked());
        AgendaActivity1.usuarioTemp.setPrefMuseos(cbMuseos.isChecked());
        AgendaActivity1.usuarioTemp.setPrefDeportes(cbDeportesPref.isChecked());

        int idx = AgendaActivity1.indexEdicion;
        if (idx >= 0) {
            AgendaActivity1.listaUsuarios.set(idx, AgendaActivity1.usuarioTemp);
            AgendaActivity1.indexEdicion = -1;
        } else {
            AgendaActivity1.listaUsuarios.add(AgendaActivity1.usuarioTemp);
        }

        UsuarioStorage.guardar(this, AgendaActivity1.listaUsuarios);
        Toast.makeText(this, "Usuario guardado exitosamente", Toast.LENGTH_SHORT).show();

        Intent i = new Intent(this, AgendaActivity1.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

    public void regresar(View v) {
        finish();
    }
}