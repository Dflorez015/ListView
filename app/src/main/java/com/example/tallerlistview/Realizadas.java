package com.example.tallerlistview;

public class Realizadas {
    private double  resultado;
    private String operacion, datos;

    public Realizadas(String operacion, String datos, double resultado) {
        this.resultado = resultado;
        this.operacion = operacion;
        this.datos = datos;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    @Override
    public String toString() {
        return "Realizadas{" +
                "resultado=" + resultado +
                ", operacion='" + operacion + '\'' +
                ", datos='" + datos + '\'' +
                '}';
    }

    public void guardar(){
        Datos.guardar(this);
    }
}
