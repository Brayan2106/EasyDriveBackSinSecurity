package pe.edu.upc.easydrive.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.easydrive.dtos.CantidadRsDTO;
import pe.edu.upc.easydrive.dtos.ReseniasDTO;
import pe.edu.upc.easydrive.entities.Resenias;
import pe.edu.upc.easydrive.servicesinterfaces.IReseniasService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/resenias")
public class ReseniasController {
    @Autowired
    private IReseniasService rS;

    @GetMapping
    public List<ReseniasDTO> listar() {
        return rS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ReseniasDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody ReseniasDTO dto) {
        ModelMapper m = new ModelMapper();
        Resenias r = m.map(dto, Resenias.class);
        rS.insert(r);
    }

    @GetMapping("/{id}")
    public ReseniasDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        return m.map(rS.listId(id), ReseniasDTO.class);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        rS.delete(id);
    }

    @PutMapping
    public void modificar(@RequestBody ReseniasDTO dto) {
        ModelMapper m = new ModelMapper();
        Resenias r = m.map(dto, Resenias.class);
        rS.update(r);
    }


    @GetMapping("/cantidad")
    public List<CantidadRsDTO> cantidadResenias() {
        List<String[]> lista = rS.cantidadService();
        List<CantidadRsDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            CantidadRsDTO dto = new CantidadRsDTO();
            dto.setNombre(columna[0]);
            dto.setCantidadResenia(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

}
