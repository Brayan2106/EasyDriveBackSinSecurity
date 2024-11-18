package pe.edu.upc.easydrive.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Servicio")
public class Servicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IDServicio;
    @Column(name = "NombreServicio",nullable = false,length = 40)
    private String NombreServicio;
    @Column(name = "Descripcion",nullable = false,length = 255)
    private  String Descripcion;
    @Column(name = "Precio",nullable = false)
    private Float Precio;
    @Column(name = "ImgServicio",length = 255)
    private String ImgServicio;

    public Servicio() {
    }

    public Servicio(String nombreServicio, int IDServicio, String descripcion, Float precio, String imgServicio) {
        NombreServicio = nombreServicio;
        this.IDServicio = IDServicio;
        Descripcion = descripcion;
        Precio = precio;
        ImgServicio = imgServicio;
    }

    public int getIDServicio() {
        return IDServicio;
    }

    public void setIDServicio(int IDServicio) {
        this.IDServicio = IDServicio;
    }

    public String getNombreServicio() {
        return NombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        NombreServicio = nombreServicio;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getImgServicio() {
        return ImgServicio;
    }

    public void setImgServicio(String imgServicio) {
        ImgServicio = imgServicio;
    }

    public Float getPrecio() {
        return Precio;
    }

    public void setPrecio(Float precio) {
        Precio = precio;
    }
}
