package pe.edu.upc.easydrive.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.easydrive.dtos.ContarNotificacionesDTO;
import pe.edu.upc.easydrive.dtos.NotificacionesDTO;
import pe.edu.upc.easydrive.entities.Notificaciones;
import pe.edu.upc.easydrive.servicesinterfaces.INotificacionesService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionesController {
    @Autowired
    private INotificacionesService nS;

    @GetMapping
    public List<NotificacionesDTO> listar() {
        return nS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, NotificacionesDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody NotificacionesDTO dto) {
        ModelMapper m = new ModelMapper();
        Notificaciones n = m.map(dto, Notificaciones.class);
        nS.insert(n);
    }

    @GetMapping("/{id}")
    public NotificacionesDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        return m.map(nS.listId(id), NotificacionesDTO.class);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void eliminar(@PathVariable("id") Integer id) {
        nS.delete(id);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void modificar(@RequestBody NotificacionesDTO dto) {
        ModelMapper m = new ModelMapper();
        Notificaciones n = m.map(dto, Notificaciones.class);
        nS.update(n);
    }

    @GetMapping("/busquedas")
    public List<NotificacionesDTO> BuscarEjemlo(String n) {
        return nS.buscar(n).stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, NotificacionesDTO.class);
        }).collect(Collectors.toList());
    }
    @GetMapping("/cantidadnotificaciones")
    public List<ContarNotificacionesDTO>contarNotificaciones(){
        List<String[]> lista=nS.numeronotificaciones();
        List<ContarNotificacionesDTO> listaDTO = new ArrayList<>();
        for (String[]columna:lista){
            ContarNotificacionesDTO dto = new ContarNotificacionesDTO();
            dto.setNombreusuario(columna[0]);
            dto.setCantnotificacion(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }

        return listaDTO;
    }
}
