package pe.edu.upc.easydrive.dtos;

public class AnalisisServiciosDTO {
    private String NombreServicio;
    private float RecaudadoPorServicio;
    private int CantidadServicios;

    public String getNombreServicio() {
        return NombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        NombreServicio = nombreServicio;
    }

    public float getRecaudadoPorServicio() {
        return RecaudadoPorServicio;
    }

    public void setRecaudadoPorServicio(float recaudadoPorServicio) {
        RecaudadoPorServicio = recaudadoPorServicio;
    }

    public int getCantidadServicios() {
        return CantidadServicios;
    }

    public void setCantidadServicios(int cantidadServicios) {
        CantidadServicios = cantidadServicios;
    }
}
