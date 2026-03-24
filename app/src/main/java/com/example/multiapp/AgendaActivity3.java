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

    CheckBox cbPlaya, cbMontana, cbCiudad, cbCampo, cbNoche, cbDia, cbSolo, cbGrupo, cbInterior, cbExterior;

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

        cbPlaya = findViewById(R.id.cbPlaya);
        cbMontana = findViewById(R.id.cbMontana);
        cbCiudad = findViewById(R.id.cbCiudad);
        cbCampo = findViewById(R.id.cbCampo);
        cbNoche = findViewById(R.id.cbNoche);
        cbDia = findViewById(R.id.cbDia);
        cbSolo = findViewById(R.id.cbSolo);
        cbGrupo = findViewById(R.id.cbGrupo);
        cbInterior = findViewById(R.id.cbInterior);
        cbExterior = findViewById(R.id.cbExterior);
    }

    public void guardar(View v) {
        AgendaActivity1.usuarioTemp.setPrefPlaya(cbPlaya.isChecked());
        AgendaActivity1.usuarioTemp.setPrefMontana(cbMontana.isChecked());
        AgendaActivity1.usuarioTemp.setPrefCiudad(cbCiudad.isChecked());
        AgendaActivity1.usuarioTemp.setPrefCampo(cbCampo.isChecked());
        AgendaActivity1.usuarioTemp.setPrefNoche(cbNoche.isChecked());
        AgendaActivity1.usuarioTemp.setPrefDia(cbDia.isChecked());
        AgendaActivity1.usuarioTemp.setPrefSolo(cbSolo.isChecked());
        AgendaActivity1.usuarioTemp.setPrefGrupo(cbGrupo.isChecked());
        AgendaActivity1.usuarioTemp.setPrefInterior(cbInterior.isChecked());
        AgendaActivity1.usuarioTemp.setPrefExterior(cbExterior.isChecked());

        AgendaActivity1.listaUsuarios.add(AgendaActivity1.usuarioTemp);

        Toast.makeText(this, "Usuario guardado exitosamente", Toast.LENGTH_SHORT).show();

        Intent i = new Intent(this, AgendaActivity1.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);
    }

    public void regresar(View v) {
        finish();
    }
}