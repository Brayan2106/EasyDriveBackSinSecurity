package pe.edu.upc.easydrive.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.easydrive.dtos.ServicioDTO;
import pe.edu.upc.easydrive.entities.Servicio;
import pe.edu.upc.easydrive.servicesinterfaces.IServicioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/servicios")
public class ServicioController {
    @Autowired
    private IServicioService sS;

    @GetMapping
    public List<ServicioDTO> listar() {
        return sS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ServicioDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody ServicioDTO dto) {
        ModelMapper m = new ModelMapper();
        Servicio s = m.map(dto, Servicio.class);
        sS.insert(s);
    }

    @GetMapping("/{id}")
    public ServicioDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        return m.map(sS.listId(id), ServicioDTO.class);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void eliminar(@PathVariable("id") Integer id) {
        sS.delete(id);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void modificar(@RequestBody ServicioDTO dto) {
        ModelMapper m = new ModelMapper();
        Servicio s = m.map(dto, Servicio.class);
        sS.update(s);
    }

    @GetMapping("/busquedas")
    public List<ServicioDTO> BuscarEjemlo(String n) {
        return sS.buscar(n).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ServicioDTO.class);
        }).collect(Collectors.toList());
    }
}
