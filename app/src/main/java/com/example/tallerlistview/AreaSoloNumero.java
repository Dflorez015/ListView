package com.example.tallerlistview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AreaSoloNumero extends AppCompatActivity {
    private String area_resultado;
    private String dt ;
    private EditText valor;
    private TextView titulo, txt;
    private double resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_solo_numero);
        valor = findViewById(R.id.lblNumero);
        titulo = findViewById(R.id.txtTituloUnSoloValor);

        txt = findViewById(R.id.txtValor);

        switch (Areas.getindexAreaOpcion()){
            case 0:
                dt = getString(R.string.lado)+": ";
                area_resultado = getString(R.string.listaOperaciones)+" "+getString(R.string.cuadrado);
                break;
            case 3:
                dt = getString(R.string.radio)+": ";
                area_resultado = getString(R.string.listaOperaciones)+" "+getString(R.string.circulo);
                break;
        }
        titulo.setText(area_resultado);
        txt.setText(dt);
    }

    public void guardar_un_valor_area(View v){
        if (!valor.getText().toString().isEmpty()){
            resultado = Integer.parseInt(valor.getText().toString());
            resultado = resultado * resultado;
            if (Areas.getindexAreaOpcion() == 3){
                resultado = (int) Math.round(resultado * Math.PI * 100);
                resultado = resultado/100.0;
            }
            String num = valor.getText().toString();
            Realizadas r = new Realizadas(area_resultado, dt+" "+num, resultado);
            r.guardar();
            alerta();
        }else {
            valor.setError(getString(R.string.errorLabel));
        }
    }

    public void alerta(){
        final AlertDialog.Builder alert = new AlertDialog.Builder(AreaSoloNumero.this);
        alert.setMessage(area_resultado+": "+resultado)
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
        AlertDialog tituloDialogo = alert.create();
        tituloDialogo.setTitle(getString(R.string.resultado));
        tituloDialogo.show();

    }

    public void borrar(View v){
        valor.setText("");
    }
}