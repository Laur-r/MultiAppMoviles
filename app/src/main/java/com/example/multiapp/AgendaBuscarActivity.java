package com.example.multiapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AgendaBuscarActivity extends AppCompatActivity {

    EditText edtBuscar, edtName, edtLastname, edtId, edtPhone, edtEmail, edtAddress, edtBirthday, edtGender, edtInterests, edtPreferences;
    Button btnEditar, btnGuardarCambios;

    Usuario usuarioEncontrado = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_agendabuscar);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtBuscar = findViewById(R.id.edtBuscar);
        edtId = findViewById(R.id.edtId);
        edtName = findViewById(R.id.edtName);
        edtLastname = findViewById(R.id.edtLastname);
        edtPhone = findViewById(R.id.edtPhone);
        edtEmail = findViewById(R.id.edtEmail);
        edtAddress = findViewById(R.id.edtAddress);
        edtBirthday = findViewById(R.id.edtBirthday);
        edtGender = findViewById(R.id.edtGender);
        edtInterests = findViewById(R.id.edtInterests);
        edtPreferences = findViewById(R.id.edtPreferences);
        btnEditar = findViewById(R.id.btnEditar);
        btnGuardarCambios = findViewById(R.id.btnGuardarCambios);
    }

    public void buscar(View v) {
        String buscar = edtBuscar.getText().toString().trim();

        if (buscar.isEmpty()) {
            Toast.makeText(this, "Ingresa una cédula para buscar", Toast.LENGTH_SHORT).show();
            return;
        }

        usuarioEncontrado = null;
        for (Usuario u : AgendaActivity1.listaUsuarios) {
            if (u.getCedula().equals(buscar)) {
                usuarioEncontrado = u;
                break;
            }
        }

        if (usuarioEncontrado != null) {
            edtId.setText(usuarioEncontrado.getCedula());
            edtName.setText(usuarioEncontrado.getNombre());
            edtLastname.setText(usuarioEncontrado.getApellido());
            edtPhone.setText(usuarioEncontrado.getTelefono());
            edtEmail.setText(usuarioEncontrado.getCorreo());
            edtAddress.setText(usuarioEncontrado.getDireccion());
            edtBirthday.setText(usuarioEncontrado.getFechaNacimiento());
            edtGender.setText(usuarioEncontrado.getSexo());

            StringBuilder intereses = new StringBuilder();

            if (usuarioEncontrado.isIntDeporte())
                intereses.append("Deporte, ");

            if (usuarioEncontrado.isIntMusica())
                intereses.append("Música, ");

            if (usuarioEncontrado.isIntCine())
                intereses.append("Cine, ");

            if (usuarioEncontrado.isIntArte())
                intereses.append("Arte, ");

            if (usuarioEncontrado.isIntLectura())
                intereses.append("Lectura, ");

            if (usuarioEncontrado.isIntViajes())
                intereses.append("Viajes, ");

            if (usuarioEncontrado.isIntCocina())
                intereses.append("Cocina, ");

            if (usuarioEncontrado.isIntTecnologia())
                intereses.append("Tecnología, ");

            if (usuarioEncontrado.isIntModa())
                intereses.append("Moda, ");

            if (usuarioEncontrado.isIntFotografia())
                intereses.append("Fotografía");

            edtInterests.setText(intereses.toString().replaceAll(", $", ""));

            StringBuilder prefs = new StringBuilder();
            if (usuarioEncontrado.isPrefPlaya())
                prefs.append("Playa, ");

            if (usuarioEncontrado.isPrefMontana())
                prefs.append("Montaña, ");

            if (usuarioEncontrado.isPrefCiudad())
                prefs.append("Ciudad, ");

            if (usuarioEncontrado.isPrefCampo())
                prefs.append("Campo, ");

            if (usuarioEncontrado.isPrefNoche())
                prefs.append("Noche, ");

            if (usuarioEncontrado.isPrefDia())
                prefs.append("Día, ");

            if (usuarioEncontrado.isPrefSolo())
                prefs.append("Solo, ");

            if (usuarioEncontrado.isPrefGrupo())
                prefs.append("Grupo, ");

            if (usuarioEncontrado.isPrefInterior())
                prefs.append("Interior, ");

            if (usuarioEncontrado.isPrefExterior())
                prefs.append("Exterior");

            edtPreferences.setText(prefs.toString().replaceAll(", $", ""));

            btnEditar.setVisibility(View.VISIBLE);
            btnGuardarCambios.setVisibility(View.GONE);

            Toast.makeText(this, "Usuario encontrado", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Usuario no encontrado", Toast.LENGTH_SHORT).show();
        }
    }

    public void editar(View v) {
        edtName.setFocusableInTouchMode(true);
        edtLastname.setFocusableInTouchMode(true);
        edtPhone.setFocusableInTouchMode(true);
        edtEmail.setFocusableInTouchMode(true);
        edtAddress.setFocusableInTouchMode(true);
        edtBirthday.setFocusableInTouchMode(true);

        btnEditar.setVisibility(View.GONE);
        btnGuardarCambios.setVisibility(View.VISIBLE);

        Toast.makeText(this, "Campos habilitados para edición", Toast.LENGTH_SHORT).show();
    }

    public void guardarCambios(View v) {
        if (usuarioEncontrado == null) return;

        usuarioEncontrado.setNombre(edtName.getText().toString().trim());
        usuarioEncontrado.setApellido(edtLastname.getText().toString().trim());
        usuarioEncontrado.setTelefono(edtPhone.getText().toString().trim());
        usuarioEncontrado.setCorreo(edtEmail.getText().toString().trim());
        usuarioEncontrado.setDireccion(edtAddress.getText().toString().trim());
        usuarioEncontrado.setFechaNacimiento(edtBirthday.getText().toString().trim());

        edtName.setFocusable(false);
        edtLastname.setFocusable(false);
        edtPhone.setFocusable(false);
        edtEmail.setFocusable(false);
        edtAddress.setFocusable(false);
        edtBirthday.setFocusable(false);

        btnGuardarCambios.setVisibility(View.GONE);
        btnEditar.setVisibility(View.VISIBLE);

        Toast.makeText(this, "Cambios guardados", Toast.LENGTH_SHORT).show();
    }

    public void regresar(View v) {
        finish();
    }
}