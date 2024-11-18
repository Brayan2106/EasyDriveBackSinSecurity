package pe.edu.upc.easydrive.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Calendario")
public class Calendario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IDCalendario;
    @Column(name = "FechaSincronizacion" , nullable = false)
    private LocalDate FechaSincronizacion;
    @ManyToOne
    @JoinColumn(name = "IDReserva")
    private Reservas res;

    public Calendario() {
    }

    public Calendario(int IDCalendario, LocalDate fechaSincronizacion, Reservas res) {
        this.IDCalendario = IDCalendario;
        this.FechaSincronizacion = fechaSincronizacion;
        this.res = res;
    }

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
