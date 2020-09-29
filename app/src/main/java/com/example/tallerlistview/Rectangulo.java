package com.example.tallerlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Rectangulo extends AppCompatActivity {
    private String area_cuadrado = getString(R.string.listaOperaciones);
    private String dt = getString(R.string.lado);
    private EditText valor;
    private int resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangulo);
    }

    public void guardar_rectangulo(View v){
        resultado = Integer.parseInt(valor.getText().toString());
        resultado = resultado * resultado;
        String num = valor.getText().toString();
        Realizadas r = new Realizadas(area_cuadrado, dt+" "+num, resultado);
        r.guardar();
    }
}