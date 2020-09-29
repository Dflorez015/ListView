package com.example.tallerlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Volumenes extends AppCompatActivity {
    private ListView lst_volumenes;
    private String[] volumenes;
    private ArrayAdapter<String> adapter;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volumenes);
        lst_volumenes = findViewById(R.id.lstVolumen);
        volumenes = getResources().getStringArray(R.array.volumen);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, volumenes);
        lst_volumenes.setAdapter(adapter);

        lst_volumenes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        intent = new Intent(Volumenes.this, Areas.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(Volumenes.this, Volumenes.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(Volumenes.this, OperacionesRealizadas.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(Volumenes.this, OperacionesRealizadas.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }
}