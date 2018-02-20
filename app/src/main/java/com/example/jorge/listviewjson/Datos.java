package com.example.jorge.listviewjson;

public class Datos {

    private String fecha;
    private String descripcion;
    private String tMax;
    private String tMin;

    public Datos(){}

    public Datos(String fecha, String descripcion, String tMax, String tMin) {
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.tMax = tMax;
        this.tMin = tMin;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String gettMax() {
        return tMax;
    }

    public void settMax(String tMax) {
        this.tMax = tMax;
    }

    public String gettMin() {
        return tMin;
    }

    public void settMin(String tMin) {
        this.tMin = tMin;
    }
}
