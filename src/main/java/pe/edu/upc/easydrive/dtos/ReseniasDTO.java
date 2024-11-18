package pe.edu.upc.easydrive.dtos;

import pe.edu.upc.easydrive.entities.CentrosMedicos;
import pe.edu.upc.easydrive.entities.Escuelas;
import pe.edu.upc.easydrive.entities.Users;

import java.time.LocalDate;

public class ReseniasDTO {
    private int IDResenia;
    private float Calificacion;
    private String Comentario;
    private LocalDate FechaResenia;
    private Users user;
    private Escuelas esc;
    private CentrosMedicos centros;

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
