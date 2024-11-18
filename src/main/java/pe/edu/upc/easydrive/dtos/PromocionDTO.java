package pe.edu.upc.easydrive.dtos;

import java.time.LocalDate;

public class PromocionDTO {
    private int IDPromocion;
    private String NombrePromocion;
    private String Descripcion;
    private int Descuento;
    private LocalDate FechaInicio;
    private LocalDate FechaFin;

    public int getIDPromocion() {
        return IDPromocion;
    }

    public void setIDPromocion(int IDPromocion) {
        this.IDPromocion = IDPromocion;
    }

    public String getNombrePromocion() {
        return NombrePromocion;
    }

    public void setNombrePromocion(String nombrePromocion) {
        NombrePromocion = nombrePromocion;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public int getDescuento() {
        return Descuento;
    }

    public void setDescuento(int descuento) {
        Descuento = descuento;
    }

    public LocalDate getFechaInicio() {
        return FechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        FechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return FechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        FechaFin = fechaFin;
    }
}
