package com.example.tallerlistview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class VolumenSoloNumero extends AppCompatActivity {
    private String volumen_resultado;
    private String dt ;
    private EditText valor;
    private TextView titulo, txt;
    private double resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumen_solo_numero);

        valor = findViewById(R.id.lblNumero);
        titulo = findViewById(R.id.txtTituloVolumenUnSoloValor);

        txt = findViewById(R.id.txtValor);

        switch (Volumenes.getIndexVolumenUnNumero()){
            case 0:
                dt = getString(R.string.radio)+": ";
                volumen_resultado= getString(R.string.listaVolumenesDeLa)+" "+getString(R.string.esfera);
                break;
            case 3:
                dt = getString(R.string.lado)+": ";
                volumen_resultado = getString(R.string.listaVolumenes)+" "+getString(R.string.cubo);
                break;
        }
        titulo.setText(volumen_resultado);
        txt.setText(dt);
    }

    public void guardar_un_valor_volumen(View v){
        if (!valor.getText().toString().isEmpty()){
            resultado = Integer.parseInt(valor.getText().toString());
            resultado = Math.pow(resultado, 3);
            if (Volumenes.getIndexVolumenUnNumero() == 0){
                resultado = (int) Math.round((4 * resultado * Math.PI)/3 * 100);
                resultado = resultado/100.0;
            }
            String num = valor.getText().toString();
            Realizadas r = new Realizadas(volumen_resultado, dt+" "+num, resultado);
            r.guardar();
            alerta();
        }else {
            valor.setError(getString(R.string.errorLabel));
        }
    }

    public void alerta(){
        final AlertDialog.Builder alert = new AlertDialog.Builder(VolumenSoloNumero.this);
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
        valor.setText("");
    }
}