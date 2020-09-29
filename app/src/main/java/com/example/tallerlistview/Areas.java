package com.example.tallerlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Areas extends AppCompatActivity {
    private ListView lstArea;
    private String[] opciones;
    private ArrayAdapter<String> adapter;
    private Intent intent;
    public static int indexAreaUnNumero = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_areas);
        lstArea = findViewById(R.id.lstArea);
        opciones = getResources().getStringArray(R.array.area);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, opciones);
        lstArea.setAdapter(adapter);

        lstArea.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                indexAreaUnNumero = i;
                switch (i){
                    case 0:
                        intent = new Intent(Areas.this, AreaSoloNumero.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(Areas.this, AreaParNumeros.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(Areas.this, AreaParNumeros.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(Areas.this, AreaSoloNumero.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }

    public static int getIndexAreaUnNumero(){
        return indexAreaUnNumero;
    }

}