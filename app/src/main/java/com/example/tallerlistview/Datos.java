package com.example.tallerlistview;

import java.util.ArrayList;

public class Datos {
    private static ArrayList<Realizadas> lista = new ArrayList<>();

    public static void guardar(Realizadas r){
        lista.add(r);
    }

    public static ArrayList<Realizadas> obtener(){
        return lista;
    }
}
