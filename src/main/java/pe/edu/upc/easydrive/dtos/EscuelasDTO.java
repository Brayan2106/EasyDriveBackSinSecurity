package pe.edu.upc.easydrive.dtos;

import jakarta.persistence.Column;
import pe.edu.upc.easydrive.entities.Promocion;

public class EscuelasDTO {
    private int IDEscuela;
    private String nombre;
    private Long Ruc;
    private String Direccion;
    private String NumeroTelefono;
    private String ImgEscuela;

    public int getIDEscuela() {
        return IDEscuela;
    }

    public void setIDEscuela(int IDEscuela) {
        this.IDEscuela = IDEscuela;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getRuc() {
        return Ruc;
    }

    public void setRuc(Long ruc) {
        Ruc = ruc;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
    }

    public String getNumeroTelefono() {
        return NumeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        NumeroTelefono = numeroTelefono;
    }

    public String getImgEscuela() {
        return ImgEscuela;
    }

    public void setImgEscuela(String imgEscuela) {
        ImgEscuela = imgEscuela;
    }
}
