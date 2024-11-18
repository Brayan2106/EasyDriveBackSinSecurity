package pe.edu.upc.easydrive.dtos;

public class ContarNotificacionesDTO {

    private String nombreusuario;
    private Integer cantnotificacion;

    public Integer getCantnotificacion() {
        return cantnotificacion;
    }

    public void setCantnotificacion(Integer cantnotificacion) {
        this.cantnotificacion = cantnotificacion;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }
}
