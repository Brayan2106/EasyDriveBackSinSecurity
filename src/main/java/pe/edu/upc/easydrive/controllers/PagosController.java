package pe.edu.upc.easydrive.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.easydrive.dtos.PagosDTO;
import pe.edu.upc.easydrive.entities.Pagos;
import pe.edu.upc.easydrive.servicesinterfaces.IPagosService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pagos")
public class PagosController {
    @Autowired
    private IPagosService pS;

    @GetMapping
    public List<PagosDTO> listar() {
        return pS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, PagosDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody PagosDTO dto) {
        ModelMapper m = new ModelMapper();
        Pagos p = m.map(dto, Pagos.class);
        pS.insert(p);
    }

    @GetMapping("/{id}")
    public PagosDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        return m.map(pS.listId(id), PagosDTO.class);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        pS.delete(id);
    }

    @PutMapping
    public void modificar(@RequestBody PagosDTO dto) {
        ModelMapper m = new ModelMapper();
        Pagos p = m.map(dto, Pagos.class);
        pS.update(p);
    }
}
