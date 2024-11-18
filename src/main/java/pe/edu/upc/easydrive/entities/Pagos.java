package pe.edu.upc.easydrive.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Pagos")
public class Pagos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IDPago;
    @Column(name = "FechaPago" , nullable = false)
    private LocalDate FechaPago;
    @Column(name = "metodoPago" , nullable = false , length = 50)
    private String metodoPago;
    @ManyToOne
    @JoinColumn(name = "IDReserva")
    private Reservas res;


    public Pagos() {
    }

    public Pagos(int IDPago, LocalDate fechaPago, String metodoPago, Reservas res) {
        this.IDPago = IDPago;
        FechaPago = fechaPago;
        this.metodoPago = metodoPago;
        this.res = res;
    }

    public int getIDPago() {
        return IDPago;
    }

    public void setIDPago(int IDPago) {
        this.IDPago = IDPago;
    }

    public LocalDate getFechaPago() {
        return FechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        FechaPago = fechaPago;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public Reservas getRes() {
        return res;
    }

    public void setRes(Reservas res) {
        this.res = res;
    }
}
