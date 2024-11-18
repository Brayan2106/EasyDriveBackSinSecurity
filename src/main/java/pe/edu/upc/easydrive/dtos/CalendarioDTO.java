package pe.edu.upc.easydrive.dtos;

import pe.edu.upc.easydrive.entities.Reservas;

import java.time.LocalDate;

public class CalendarioDTO {
    private int IDCalendario;
    private LocalDate FechaSincronizacion;
    private Reservas res;

    public int getIDCalendario() {
        return IDCalendario;
    }

    public void setIDCalendario(int IDCalendario) {
        this.IDCalendario = IDCalendario;
    }

    public LocalDate getFechaSincronizacion() {
        return FechaSincronizacion;
    }

    public void setFechaSincronizacion(LocalDate fechaSincronizacion) {
        FechaSincronizacion = fechaSincronizacion;
    }

    public Reservas getRes() {
        return res;
    }

    public void setRes(Reservas res) {
        this.res = res;
    }
}
