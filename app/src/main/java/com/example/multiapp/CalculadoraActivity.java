package com.example.multiapp;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CalculadoraActivity extends AppCompatActivity {

    private Button b9, b8, b7, b6, b5, b4, b3, b2, b1, b0, clean, bp, suma, resta, division, multiplicacion;
    private TextView caja;

    private String cadena = "";
    private double num1 = 0;
    private double num2 = 0;
    private String operacion = "";
    private boolean esperandoSegundoNumero = false;

    private ArrayList<String> historial = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculadora);

        b9 = findViewById(R.id.b9);
        b8 = findViewById(R.id.b8);
        b7 = findViewById(R.id.b7);
        b6 = findViewById(R.id.b6);
        b5 = findViewById(R.id.b5);
        b4 = findViewById(R.id.b4);
        b3 = findViewById(R.id.b3);
        b2 = findViewById(R.id.b2);
        b1 = findViewById(R.id.b1);
        b0 = findViewById(R.id.b0);
        clean = findViewById(R.id.clean);
        bp = findViewById(R.id.bp);
        caja = findViewById(R.id.caja);
    }


    private void agregarDigito(String digito) {
        if (cadena.replace(".", "").replace("-", "").length() >= 10) {
            Toast.makeText(this, "Máximo 10 dígitos", Toast.LENGTH_SHORT).show();
            return;
        }
        if (cadena.equals("0") && digito.equals("0")) return;
        if (cadena.equals("0") && !digito.equals(".")) cadena = "";

        cadena = cadena + digito;
        visualizar();
    }

    public void t0(View v) {
        agregarDigito("0");
    }
    public void t1(View v) {
        agregarDigito("1");
    }
    public void t2(View v) {
        agregarDigito("2");
    }
    public void t3(View v) {
        agregarDigito("3");
    }
    public void t4(View v) {
        agregarDigito("4");
    }
    public void t5(View v) {
        agregarDigito("5");
    }
    public void t6(View v) {
        agregarDigito("6");
    }
    public void t7(View v) {
        agregarDigito("7");
    }
    public void t8(View v) {
        agregarDigito("8");
    }
    public void t9(View v) {
        agregarDigito("9");
    }

    public void punto(View v) {
        if (cadena.contains(".")) {
            Toast.makeText(this, "Ya hay un punto decimal", Toast.LENGTH_SHORT).show();
            return;
        }
        if (cadena.isEmpty()) cadena = "0";
        cadena = cadena + ".";
        visualizar();
    }


    private void seleccionarOperacion(String op) {
        if (cadena.isEmpty()) {
            Toast.makeText(this, "Ingresa un número primero", Toast.LENGTH_SHORT).show();
            return;
        }
        num1 = Double.parseDouble(cadena);
        operacion = op;
        cadena = "";
        esperandoSegundoNumero = true;
    }

    public void suma(View v) {
        seleccionarOperacion("+");
    }
    public void resta(View v) {
        seleccionarOperacion("-");
    }
    public void multiplicacion(View v) {
        seleccionarOperacion("*");
    }
    public void division(View v) {
        seleccionarOperacion("/");
    }


    public void igual(View v) {
        if (operacion.isEmpty()) {
            Toast.makeText(this, "Selecciona una operación", Toast.LENGTH_SHORT).show();
            return;
        }
        if (cadena.isEmpty()) {
            Toast.makeText(this, "Ingresa el segundo número", Toast.LENGTH_SHORT).show();
            return;
        }

        num2 = Double.parseDouble(cadena);

        if (operacion.equals("/") && num2 == 0) {
            Toast.makeText(this, "No se puede dividir entre cero", Toast.LENGTH_SHORT).show();
            return;
        }

        double resultado = 0;
        String simbolo = operacion;
        switch (operacion) {
            case "+": resultado = num1 + num2; simbolo = "+";
            break;
            case "-": resultado = num1 - num2; simbolo = "−";
            break;
            case "*": resultado = num1 * num2; simbolo = "×";
            break;
            case "/": resultado = num1 / num2; simbolo = "÷";
            break;
        }

        String resultadoStr;
        if (resultado == (long) resultado) {
            resultadoStr = String.valueOf((long) resultado);
        } else {
            resultadoStr = String.valueOf(resultado);
        }

        String entrada1 = num1 == (long) num1 ? String.valueOf((long) num1) : String.valueOf(num1);
        String entrada2 = num2 == (long) num2 ? String.valueOf((long) num2) : String.valueOf(num2);

        String registro = entrada1 + " " + simbolo + " " + entrada2 + " = " + resultadoStr;
        historial.add(registro);

        cadena = resultadoStr;
        operacion = "";
        esperandoSegundoNumero = false;
        visualizar();
    }

    public void limpiar(View v) {
        cadena = "";
        num1 = 0;
        num2 = 0;
        operacion = "";
        esperandoSegundoNumero = false;
        caja.setText("0");
    }


    public void visualizar() {
        caja.setText(cadena.isEmpty() ? "0" : cadena);
    }


    public void memoria(View v) {
        if (historial.isEmpty()) {
            Toast.makeText(this, "El historial está vacío", Toast.LENGTH_SHORT).show();
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = historial.size() - 1; i >= 0; i--) {
            sb.append(historial.get(i)).append("\n");
        }

        new AlertDialog.Builder(this)
                .setTitle("Historial de operaciones")
                .setMessage(sb.toString().trim())
                .setPositiveButton("Cerrar", null)
                .setNegativeButton("Borrar historial", (dialog, which) -> {
                    historial.clear();
                    Toast.makeText(this, "Historial borrado", Toast.LENGTH_SHORT).show();
                })
                .show();
    }

    public void regresar(View v) {
        finish();
    }
}