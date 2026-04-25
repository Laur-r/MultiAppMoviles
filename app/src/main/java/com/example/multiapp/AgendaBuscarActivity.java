package com.example.multiapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class AgendaBuscarActivity extends AppCompatActivity {

    EditText edtBuscar, edtName, edtLastname, edtId, edtPhone, edtEmail, edtAddress, edtBirthday, edtGender;
    TextView tvInterests, tvPreferences;
    Button btnEditar, btnGuardarCambios, btnEditarIntereses;

    Usuario usuarioEncontrado = null;
    int indexEncontrado = -1;

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

        edtBuscar         = findViewById(R.id.edtBuscar);
        edtId             = findViewById(R.id.edtId);
        edtName           = findViewById(R.id.edtName);
        edtLastname       = findViewById(R.id.edtLastname);
        edtPhone          = findViewById(R.id.edtPhone);
        edtEmail          = findViewById(R.id.edtEmail);
        edtAddress        = findViewById(R.id.edtAddress);
        edtBirthday       = findViewById(R.id.edtBirthday);
        edtGender         = findViewById(R.id.edtGender);
        tvInterests       = findViewById(R.id.tvInterests);
        tvPreferences     = findViewById(R.id.tvPreferences);
        btnEditar         = findViewById(R.id.btnEditar);
        btnGuardarCambios = findViewById(R.id.btnGuardarCambios);
        btnEditarIntereses = findViewById(R.id.btnEditarIntereses);
        edtBirthday.setOnClickListener(vv -> {
            if (edtBirthday.isFocusableInTouchMode()) {
                abrirDatePicker();
            }
        });
    }

    // ── Buscar ──────────────────────────────────────────────────────────────

    public void buscar(View v) {
        String buscar = edtBuscar.getText().toString().trim();
        if (buscar.isEmpty()) {
            Toast.makeText(this, "Ingresa una cédula para buscar", Toast.LENGTH_SHORT).show();
            return;
        }

        usuarioEncontrado = null;
        indexEncontrado = -1;

        for (int i = 0; i < AgendaActivity1.listaUsuarios.size(); i++) {
            Usuario u = AgendaActivity1.listaUsuarios.get(i);
            if (u.getCedula().equals(buscar)) {
                usuarioEncontrado = u;
                indexEncontrado = i;
                break;
            }
        }

        if (usuarioEncontrado != null) {
            mostrarUsuario(usuarioEncontrado);
            btnEditar.setVisibility(View.VISIBLE);
            btnEditarIntereses.setVisibility(View.VISIBLE);
            btnGuardarCambios.setVisibility(View.GONE);
            Toast.makeText(this, "Usuario encontrado", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Usuario no encontrado", Toast.LENGTH_SHORT).show();
        }
    }

    // ── Mostrar datos ────────────────────────────────────────────────────────

    private void mostrarUsuario(Usuario u) {
        edtId.setText(u.getCedula());
        edtName.setText(u.getNombre());
        edtLastname.setText(u.getApellido());
        edtPhone.setText(u.getTelefono());
        edtEmail.setText(u.getCorreo());
        edtAddress.setText(u.getDireccion());
        edtBirthday.setText(u.getFechaNacimiento());
        edtGender.setText(u.getSexo());
        tvInterests.setText(u.getInteresesTexto());
        tvPreferences.setText(u.getPreferenciasTexto());
    }

    // ── Editar datos personales ──────────────────────────────────────────────

    public void editar(View v) {
        if (usuarioEncontrado == null) return;

        edtName.setFocusableInTouchMode(true);
        edtLastname.setFocusableInTouchMode(true);
        edtPhone.setFocusableInTouchMode(true);
        edtEmail.setFocusableInTouchMode(true);
        edtAddress.setFocusableInTouchMode(true);
        edtBirthday.setFocusableInTouchMode(true);
        btnEditar.setVisibility(View.GONE);
        btnGuardarCambios.setVisibility(View.VISIBLE);
    }

    // ── DatePickerDialog ─────────────────────────────────────────────────────

    private void abrirDatePicker() {
        Calendar cal = Calendar.getInstance();

        String fechaActual = edtBirthday.getText().toString();
        if (!fechaActual.isEmpty()) {
            try {
                String[] partes = fechaActual.split("/");
                cal.set(Integer.parseInt(partes[2]),
                        Integer.parseInt(partes[1]) - 1,
                        Integer.parseInt(partes[0]));
            } catch (Exception ignored) {}
        }

        DatePickerDialog picker = new DatePickerDialog(
                this,
                (datePicker, year, month, day) -> {
                    String fecha = String.format("%02d/%02d/%04d", day, month + 1, year);
                    edtBirthday.setText(fecha);
                },
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
        );
        picker.show();
    }

    // ── Editar intereses y preferencias ─────────────────────────────────────

    public void editarIntereses(View v) {
        if (usuarioEncontrado == null) {
            Toast.makeText(this, "Primero busca un usuario", Toast.LENGTH_SHORT).show();
            return;
        }

        AgendaActivity1.usuarioTemp = usuarioEncontrado;
        AgendaActivity1.indexEdicion = indexEncontrado;
        startActivity(new Intent(this, AgendaActivity2.class));
    }

    // ── Guardar cambios de datos personales ─────────────────────────────────

    public void guardarCambios(View v) {
        if (usuarioEncontrado == null) return;

        usuarioEncontrado.setNombre(edtName.getText().toString().trim());
        usuarioEncontrado.setApellido(edtLastname.getText().toString().trim());
        usuarioEncontrado.setTelefono(edtPhone.getText().toString().trim());
        usuarioEncontrado.setCorreo(edtEmail.getText().toString().trim());
        usuarioEncontrado.setDireccion(edtAddress.getText().toString().trim());
        usuarioEncontrado.setFechaNacimiento(edtBirthday.getText().toString().trim());
        usuarioEncontrado.setSexo(edtGender.getText().toString().trim());
        edtName.setFocusable(false);
        edtLastname.setFocusable(false);
        edtPhone.setFocusable(false);
        edtEmail.setFocusable(false);
        edtAddress.setFocusable(false);
        edtBirthday.setFocusable(false);

        btnGuardarCambios.setVisibility(View.GONE);
        btnEditar.setVisibility(View.VISIBLE);

        UsuarioStorage.guardar(this, AgendaActivity1.listaUsuarios);
        Toast.makeText(this, "Cambios guardados", Toast.LENGTH_SHORT).show();
    }

    public void regresar(View v) {
        finish();
    }
}