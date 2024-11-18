package pe.edu.upc.easydrive.dtos;

public class CalificacionesEscuelasDTO {
    private String NombreEscuela;
    private double promedioCalificacion;

    public String getNombreEscuela() {
        return NombreEscuela;
    }

    public void setNombreEscuela(String nombreEscuela) {
        NombreEscuela = nombreEscuela;
    }

    public double getPromedioCalificacion() {
        return promedioCalificacion;
    }

    public void setPromedioCalificacion(double promedioCalificacion) {
        this.promedioCalificacion = promedioCalificacion;
    }
}
