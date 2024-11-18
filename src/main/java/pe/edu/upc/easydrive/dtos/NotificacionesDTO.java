package pe.edu.upc.easydrive.dtos;

import pe.edu.upc.easydrive.entities.Users;

import java.time.LocalDate;

public class NotificacionesDTO {
    private int IDNotificacion;
    private String Titulo;
    private String Mensaje;
    private LocalDate FechaNotificacion;
    private Users user;

    public int getIDNotificacion() {
        return IDNotificacion;
    }

    public void setIDNotificacion(int IDNotificacion) {
        this.IDNotificacion = IDNotificacion;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getMensaje() {
        return Mensaje;
    }

    public void setMensaje(String mensaje) {
        Mensaje = mensaje;
    }

    public LocalDate getFechaNotificacion() {
        return FechaNotificacion;
    }

    public void setFechaNotificacion(LocalDate fechaNotificacion) {
        FechaNotificacion = fechaNotificacion;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
