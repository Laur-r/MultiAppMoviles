package com.example.multiapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Calendar;

public class AgendaActivity1 extends AppCompatActivity {

    EditText edtNombre, edtApellido, edtCedula, edtTelefono, edtCorreo, edtDireccion, edtFechaNacimiento;
    RadioGroup rgSexo;
    RadioButton rbFemenino, rbMasculino;

    static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    static Usuario usuarioTemp = new Usuario();
    static int indexEdicion = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_agenda1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listaUsuarios = UsuarioStorage.cargar(this);

        edtNombre          = findViewById(R.id.edtNombre);
        edtApellido        = findViewById(R.id.edtApellido);
        edtCedula          = findViewById(R.id.edtCedula);
        edtTelefono        = findViewById(R.id.edtTelefono);
        edtCorreo          = findViewById(R.id.edtCorreo);
        edtDireccion       = findViewById(R.id.edtDireccion);
        edtFechaNacimiento = findViewById(R.id.edtFechaNacimiento);
        rgSexo             = findViewById(R.id.rgSexo);
        rbFemenino         = findViewById(R.id.rbFemenino);
        rbMasculino        = findViewById(R.id.rbMasculino);


        edtFechaNacimiento.setOnClickListener(v -> abrirDatePicker());
    }

    private void abrirDatePicker() {
        Calendar cal = Calendar.getInstance();

        String fechaActual = edtFechaNacimiento.getText().toString();
        if (!fechaActual.isEmpty()) {
            try {
                String[] partes = fechaActual.split("/");
                cal.set(Integer.parseInt(partes[2]),
                        Integer.parseInt(partes[1]) - 1,
                        Integer.parseInt(partes[0]));
            } catch (Exception ignored) {}
        }

        new DatePickerDialog(
                this,
                (datePicker, year, month, day) -> {
                    String fecha = String.format("%02d/%02d/%04d", day, month + 1, year);
                    edtFechaNacimiento.setText(fecha);
                },
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
        ).show();
    }

    public void intereses(View v) {
        String nombre   = edtNombre.getText().toString().trim();
        String apellido = edtApellido.getText().toString().trim();
        String cedula   = edtCedula.getText().toString().trim();

        if (nombre.isEmpty() || apellido.isEmpty() || cedula.isEmpty()) {
            Toast.makeText(this, "Llena nombre, apellido y cédula antes de continuar",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        String sexo = "";
        if (rbFemenino.isChecked())       sexo = "Femenino";
        else if (rbMasculino.isChecked()) sexo = "Masculino";
        else {
            Toast.makeText(this, "Selecciona un sexo", Toast.LENGTH_SHORT).show();
            return;
        }

        indexEdicion = -1;

        usuarioTemp = new Usuario();
        usuarioTemp.setNombre(nombre);
        usuarioTemp.setApellido(apellido);
        usuarioTemp.setCedula(cedula);
        usuarioTemp.setSexo(sexo);
        usuarioTemp.setTelefono(edtTelefono.getText().toString().trim());
        usuarioTemp.setCorreo(edtCorreo.getText().toString().trim());
        usuarioTemp.setDireccion(edtDireccion.getText().toString().trim());
        usuarioTemp.setFechaNacimiento(edtFechaNacimiento.getText().toString().trim());

        startActivity(new Intent(this, AgendaActivity2.class));
    }

    public void verAgenda(View v) {
        startActivity(new Intent(this, AgendaBuscarActivity.class));
    }

    public void regresar(View v) {
        finish();
    }
}