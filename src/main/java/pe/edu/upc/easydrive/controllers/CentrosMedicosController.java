package pe.edu.upc.easydrive.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.easydrive.dtos.CentrosMedicosDTO;
import pe.edu.upc.easydrive.dtos.promcentrosDTO;
import pe.edu.upc.easydrive.entities.CentrosMedicos;
import pe.edu.upc.easydrive.servicesinterfaces.ICentrosMedicosService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/centros")
public class CentrosMedicosController {
    @Autowired
    private ICentrosMedicosService cS;

    @GetMapping
    public List<CentrosMedicosDTO> listar() {
        return cS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CentrosMedicosDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody CentrosMedicosDTO dto) {
        ModelMapper m = new ModelMapper();
        CentrosMedicos c = m.map(dto, CentrosMedicos.class);
        cS.insert(c);
    }

    @GetMapping("/{id}")
    public CentrosMedicosDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        return m.map(cS.listId(id), CentrosMedicosDTO.class);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void eliminar(@PathVariable("id") Integer id) {
        cS.delete(id);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void modificar(@RequestBody CentrosMedicosDTO dto) {
        ModelMapper m = new ModelMapper();
        CentrosMedicos c = m.map(dto, CentrosMedicos.class);
        cS.update(c);
    }

    @GetMapping("/busquedas")
    public List<CentrosMedicosDTO> BuscarEjemlo(String n) {
        return cS.buscar(n).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, CentrosMedicosDTO.class);
        }).collect(Collectors.toList());
    }

    @GetMapping("/centrosreseinaspromedio")
    public List<promcentrosDTO> calificacionpromedioporescuelas() {
        List<String[]> lista = cS.promedioreseniacentros();
        List<promcentrosDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            promcentrosDTO dto = new promcentrosDTO();
            dto.setNombrecentro(columna[0]);
            dto.setAvgreseinas(Double.parseDouble(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
