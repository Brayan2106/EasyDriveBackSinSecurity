package pe.edu.upc.easydrive.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Resenias")
public class Resenias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IDResenia;
    @Column(name = "Calificacion", nullable = false)
    private float Calificacion;
    @Column(name = "Comentario", nullable = false, length = 500)
    private String Comentario;
    @Column(name = "FechaReseña", nullable = false)
    private LocalDate FechaResenia;
    @ManyToOne
    @JoinColumn(name = "IDUsuario")
    private Users user;
    @ManyToOne
    @JoinColumn(name = "IDEscuelas")
    private Escuelas esc;
    @ManyToOne
    @JoinColumn(name = "IDCentro")
    private CentrosMedicos centros;

    public Resenias() {
    }

    public Resenias(int IDResenia, float calificacion, String comentario, LocalDate fechaResenia, Users user, Escuelas esc, CentrosMedicos centros) {
        this.IDResenia = IDResenia;
        this.Calificacion = calificacion;
        this.Comentario = comentario;
        this.FechaResenia = fechaResenia;
        this.user = user;
        this.esc = esc;
        this.centros = centros;
    }

    public int getIDResenia() {
        return IDResenia;
    }

    public void setIDResenia(int IDResenia) {
        this.IDResenia = IDResenia;
    }

    public float getCalificacion() {
        return Calificacion;
    }

    public void setCalificacion(float calificacion) {
        Calificacion = calificacion;
    }

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String comentario) {
        Comentario = comentario;
    }

    public LocalDate getFechaResenia() {
        return FechaResenia;
    }

    public void setFechaResenia(LocalDate fechaResenia) {
        FechaResenia = fechaResenia;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Escuelas getEsc() {
        return esc;
    }

    public void setEsc(Escuelas esc) {
        this.esc = esc;
    }

    public CentrosMedicos getCentros() {
        return centros;
    }

    public void setCentros(CentrosMedicos centros) {
        this.centros = centros;
    }
}
