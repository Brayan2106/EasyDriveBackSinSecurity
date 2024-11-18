package pe.edu.upc.easydrive.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Notificaciones")
public class Notificaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IDNotificacion;
    @Column(name = "Titulo", nullable = false, length = 100)
    private String Titulo;
    @Column(name = "Mensaje", nullable = false, length = 1000)
    private String Mensaje;
    @Column(name = "FechaNotificacion")
    private LocalDate FechaNotificacion;
    @ManyToOne
    @JoinColumn(name = "IDUsuario")
    private Users user;

    public Notificaciones() {
    }

    public Notificaciones(int IDNotificacion, String titulo, String mensaje, LocalDate fechaNotificacion, Users user) {
        this.IDNotificacion = IDNotificacion;
        this.Titulo = titulo;
        this.Mensaje = mensaje;
        this.FechaNotificacion = fechaNotificacion;
        this.user = user;
    }

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
