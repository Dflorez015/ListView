package com.example.tallerlistview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class VolumenParNumero extends AppCompatActivity {
    private String volumen_resultado;
    private String dtr, dtl ;
    private EditText valorA, valorB;
    private TextView titulo, txta, txtb;
    private double resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumen_par_numero);
        valorA = findViewById(R.id.lblNumeroA);
        valorB = findViewById(R.id.lblNumeroB);
        titulo = findViewById(R.id.txtTituloVolumenDosValores);
        txta = findViewById(R.id.txtValorA);
        txta.setText(getString(R.string.radio)+":");
        txtb = findViewById(R.id.txtValorB);
        txtb.setText(getString(R.string.altura)+":");
        dtr = getString(R.string.radio);
        dtl = getString(R.string.altura);
        switch (Volumenes.getIndexVolumenUnNumero()){
            case 1:
                volumen_resultado= getString(R.string.listaVolumenes)+" "+getString(R.string.cilindro);
                break;
            case 2:
                volumen_resultado = getString(R.string.listaVolumenes)+" "+getString(R.string.cono);
                break;
        }
        titulo.setText(volumen_resultado);
    }

    public void guardar_dos_valor_volumen(View v){
        boolean txta_empty = valorA.getText().toString().isEmpty();
        boolean txtb_empty = valorB.getText().toString().isEmpty();
        if (!txta_empty && !txtb_empty){
            int a = Integer.parseInt(valorA.getText().toString());
            int b = Integer.parseInt(valorB.getText().toString());
            resultado = (int) Math.round((Math.pow(a, 2) * b * Math.PI)*100);
            resultado = resultado/100;
            if (Volumenes.getIndexVolumenUnNumero() == 2){
                resultado = resultado/3;
            }
            Realizadas r = new Realizadas(volumen_resultado, dtr+": "+a+"\n"+dtl+": "+b, resultado);
            r.guardar();
            alerta();
        }else{
            if (txta_empty){
                valorA.setError(getString(R.string.errorLabel));
            }else{
                valorB.setError(getString(R.string.errorLabel));
            }
        }
    }

    public void alerta(){
        final AlertDialog.Builder alert = new AlertDialog.Builder(VolumenParNumero.this);
        alert.setMessage(volumen_resultado+": "+resultado)
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
        valorA.setText("");
        valorB.setText("");
    }
}