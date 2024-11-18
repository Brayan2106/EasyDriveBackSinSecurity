package pe.edu.upc.easydrive.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.easydrive.dtos.CalendarioDTO;
import pe.edu.upc.easydrive.entities.Calendario;
import pe.edu.upc.easydrive.servicesinterfaces.ICalendarioService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/calendario")
public class CalendarioController {
    @Autowired
    private ICalendarioService cS;

    @GetMapping
    public List<CalendarioDTO> listar() {
        return cS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CalendarioDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody CalendarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Calendario c = m.map(dto, Calendario.class);
        cS.insert(c);
    }

    @GetMapping("/{id}")
    public CalendarioDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        return m.map(cS.listId(id), CalendarioDTO.class);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ESTUDIANTE')")
    public void eliminar(@PathVariable("id") Integer id) {
        cS.delete(id);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void modificar(@RequestBody CalendarioDTO dto) {
        ModelMapper m = new ModelMapper();
        Calendario c = m.map(dto, Calendario.class);
        cS.update(c);
    }

}
