package pe.edu.upc.easydrive.dtos;

public class RolDTO {
    private int IDRol;
    private String NombreRol;

    public String getNombreRol() {
        return NombreRol;
    }

    public void setNombreRol(String nombreRol) {
        NombreRol = nombreRol;
    }

    public int getIDRol() {
        return IDRol;
    }

    public void setIDRol(int IDRol) {
        this.IDRol = IDRol;
    }
}
