package com.example.multiapp;

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

public class AgendaActivity1 extends AppCompatActivity {

    EditText edtNombre, edtApellido, edtCedula, edtTelefono, edtCorreo, edtDireccion, edtFechaNacimiento;
    RadioGroup rgSexo;
    RadioButton rbFemenino, rbMasculino;

    static ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    static Usuario usuarioTemp = new Usuario();

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

        edtNombre = findViewById(R.id.edtNombre);
        edtApellido = findViewById(R.id.edtApellido);
        edtCedula = findViewById(R.id.edtCedula);
        edtTelefono = findViewById(R.id.edtTelefono);
        edtCorreo = findViewById(R.id.edtCorreo);
        edtDireccion = findViewById(R.id.edtDireccion);
        edtFechaNacimiento = findViewById(R.id.edtFechaNacimiento);
        rgSexo = findViewById(R.id.rgSexo);
        rbFemenino = findViewById(R.id.rbFemenino);
        rbMasculino = findViewById(R.id.rbMasculino);
    }

    public void intereses(View v) {
        String nombre = edtNombre.getText().toString().trim();
        String apellido = edtApellido.getText().toString().trim();
        String cedula = edtCedula.getText().toString().trim();

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