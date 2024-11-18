package pe.edu.upc.easydrive.dtos;

public class GananciasPromosDTO {
    private String NombrePromocion;
    private float Ganancia;

    public String getNombrePromocion() {
        return NombrePromocion;
    }

    public void setNombrePromocion(String nombrePromocion) {
        NombrePromocion = nombrePromocion;
    }

    public float getGanancia() {
        return Ganancia;
    }

    public void setGanancia(float ganancia) {
        Ganancia = ganancia;
    }
}
