package pe.edu.upc.easydrive.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.easydrive.dtos.PromocionDTO;
import pe.edu.upc.easydrive.entities.Promocion;
import pe.edu.upc.easydrive.servicesinterfaces.IPromocionService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/promociones")
public class PromocionController {
    @Autowired
    private IPromocionService pS;

    @GetMapping
    public List<PromocionDTO> listar() {
        return pS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, PromocionDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void inserir(@RequestBody PromocionDTO dto) {
        ModelMapper m = new ModelMapper();
        Promocion p = m.map(dto, Promocion.class);
        pS.insert(p);
    }

    @GetMapping("/{id}")
    public PromocionDTO buscar(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        return m.map(pS.listId(id), PromocionDTO.class);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void eliminar(@PathVariable("id") Integer id) {
        pS.delete(id);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void modificar(@RequestBody PromocionDTO dto) {
        ModelMapper m = new ModelMapper();
        Promocion p = m.map(dto, Promocion.class);
        pS.update(p);
    }

    @GetMapping("/busquedas")
    public List<PromocionDTO> buscarEjem(String n) {
        return pS.buscar(n).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, PromocionDTO.class);
        }).collect(Collectors.toList());
    }
}
