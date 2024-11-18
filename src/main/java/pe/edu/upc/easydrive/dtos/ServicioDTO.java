package pe.edu.upc.easydrive.dtos;

public class ServicioDTO {
    private int IDServicio;
    private String NombreServicio;
    private String Descripcion;
    private Float Precio;
    private String ImgServicio;


    public int getIDServicio() {
        return IDServicio;
    }

    public void setIDServicio(int IDServicio) {
        this.IDServicio = IDServicio;
    }

    public String getNombreServicio() {
        return NombreServicio;
    }

    public void setNombreServicio(String nombreServicio) {
        NombreServicio = nombreServicio;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Float getPrecio() {
        return Precio;
    }

    public void setPrecio(Float precio) {
        Precio = precio;
    }

    public String getImgServicio() {
        return ImgServicio;
    }

    public void setImgServicio(String imgServicio) {
        ImgServicio = imgServicio;
    }
}
