package pe.edu.upc.easydrive.dtos;

import jakarta.persistence.Column;

public class CentrosMedicosDTO {
    private int IDCentro;
    private String Nombre;
    private long RUC;
    private String ImgCentro;
    private String direccion;
    private String NumeroTelefono;

    public int getIDCentro() {
        return IDCentro;
    }

    public void setIDCentro(int IDCentro) {
        this.IDCentro = IDCentro;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public long getRUC() {
        return RUC;
    }

    public void setRUC(long RUC) {
        this.RUC = RUC;
    }

    public String getImgCentro() {
        return ImgCentro;
    }

    public void setImgCentro(String imgCentro) {
        ImgCentro = imgCentro;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroTelefono() {
        return NumeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        NumeroTelefono = numeroTelefono;
    }
}
