package pe.edu.upc.easydrive.dtos;

public class CantidadRsDTO {
    private String nombre ;
    private int cantidadResenia;

    public int getCantidadResenia() {
        return cantidadResenia;
    }

    public void setCantidadResenia(int cantidadResenia) {
        this.cantidadResenia = cantidadResenia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
