package pe.edu.upc.easydrive.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Promocion")
public class Promocion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IDPromocion;
    @Column(name = "NombrePromocion", nullable = false , length = 40)
    private String NombrePromocion;
    @Column(name = "Descripcion", nullable = false , length = 255)
    private String Descripcion;
    @Column(name = "Descuento" , nullable = false)
    private int Descuento;
    @Column(name = "FechaInicio" , nullable = false)
    private LocalDate FechaInicio;
    @Column(name = "FechaFin" , nullable = false)
    private LocalDate FechaFin;

    public Promocion() {

    }

    public Promocion(int IDPromocion , String NombrePromocion , String Descripcion , int Descuento , LocalDate FechaInicio , LocalDate FechaFin) {
        this.IDPromocion = IDPromocion;
        this.NombrePromocion = NombrePromocion;
        this.Descripcion = Descripcion;
        this.Descuento = Descuento;
        this.FechaInicio = FechaInicio;
        this.FechaFin = FechaFin;
    }

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
