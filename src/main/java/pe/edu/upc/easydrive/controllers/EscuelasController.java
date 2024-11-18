package pe.edu.upc.easydrive.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.easydrive.dtos.CalificacionesEscuelasDTO;
import pe.edu.upc.easydrive.dtos.EscuelasDTO;
import pe.edu.upc.easydrive.entities.Escuelas;
import pe.edu.upc.easydrive.servicesinterfaces.IEscuelasService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/escuela")
public class EscuelasController {
    @Autowired
    private IEscuelasService eS;

    @GetMapping
    public List<EscuelasDTO> listar() {
        return eS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, EscuelasDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody EscuelasDTO dto) {
        ModelMapper m = new ModelMapper();
        Escuelas e = m.map(dto, Escuelas.class);
        eS.insert(e);
    }

    @GetMapping("/{id}")
    public EscuelasDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        return m.map(eS.listId(id), EscuelasDTO.class);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void eliminar(@PathVariable("id") Integer id) {              
        eS.delete(id);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void modificar(@RequestBody EscuelasDTO dto) {
        ModelMapper m = new ModelMapper();
        Escuelas e = m.map(dto, Escuelas.class);
        eS.update(e);
    }

    @GetMapping("/busquedas")
    public List<EscuelasDTO> BuscarEjemlo(String n) {
        return eS.buscar(n).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, EscuelasDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/calificacionpromedioporescuelas")
    public List<CalificacionesEscuelasDTO> calificacionpromedioporescuelas() {
        List<String[]> lista = eS.CalificacionPromedioPorEscuelas();
        List<CalificacionesEscuelasDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            CalificacionesEscuelasDTO dto = new CalificacionesEscuelasDTO();
            dto.setNombreEscuela(columna[0]);
            dto.setPromedioCalificacion(Double.parseDouble(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
