package com.example.tallerlistview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AreaParNumeros extends AppCompatActivity {
    private String area_resultado;
    private String dt ;
    private EditText valorA, valorB;
    private TextView titulo, txta, txtb;
    private double resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_par_numeros);
        valorA = findViewById(R.id.lblNumeroA);
        valorB = findViewById(R.id.lblNumeroB);
        titulo = findViewById(R.id.txtTituloParValores);
        txta = findViewById(R.id.txtValorA);
        txta.setText(getString(R.string.lado)+" A :");
        txtb = findViewById(R.id.txtValorB);
        txtb.setText(getString(R.string.lado)+" B :");
        dt = getString(R.string.lado);
        switch (Areas.getIndexAreaUnNumero()){
            case 1:
                area_resultado = getString(R.string.listaOperaciones)+" "+getString(R.string.rectangulo);
                break;
            case 2:
                area_resultado = getString(R.string.listaOperaciones)+" "+getString(R.string.triangulo);
                break;
        }
        titulo.setText(area_resultado);
    }

    public void guardar_dos_valor_area(View v){
        boolean txta_empty = valorA.getText().toString().isEmpty();
        boolean txtb_empty = valorB.getText().toString().isEmpty();
        if (!txta_empty && !txtb_empty){
            int a = Integer.parseInt(valorA.getText().toString());
            int b = Integer.parseInt(valorB.getText().toString());
            resultado = a * b;
            if (Areas.getIndexAreaUnNumero() == 2){
                resultado = resultado/2;
            }
            Realizadas r = new Realizadas(area_resultado, dt+" A: "+a+"\n"+dt+" B: "+b, resultado);
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
        final AlertDialog.Builder alert = new AlertDialog.Builder(AreaParNumeros.this);
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
        valorA.setText("");
        valorB.setText("");
    }
}