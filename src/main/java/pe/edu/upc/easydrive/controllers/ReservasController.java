package pe.edu.upc.easydrive.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.easydrive.dtos.*;
import pe.edu.upc.easydrive.entities.Reservas;
import pe.edu.upc.easydrive.servicesinterfaces.IReservasService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reservas")
public class ReservasController {
    @Autowired
    private IReservasService rS;

    @GetMapping
    public List<ReservasDTO> listar() {
        return rS.list().stream().map(x -> {
            ModelMapper m = new ModelMapper();
            return m.map(x, ReservasDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void insertar(@RequestBody ReservasDTO dto) {
        ModelMapper m = new ModelMapper();
        Reservas r = m.map(dto, Reservas.class);
        rS.insert(r);
    }

    @GetMapping("/{id}")
    public ReservasDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper m = new ModelMapper();
        return m.map(rS.listId(id), ReservasDTO.class);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        rS.delete(id);
    }

    @PutMapping
    public void modificar(@RequestBody ReservasDTO dto) {
        ModelMapper m = new ModelMapper();
        Reservas r = m.map(dto, Reservas.class);
        rS.update(r);
    }


    @GetMapping("/suma")
    public List<SumaDTO> sumaTotal() {
        List<String[]> lista = rS.sumaService();
        List<SumaDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            SumaDTO dto = new SumaDTO();
            dto.setNombre(columna[0]);
            dto.setSumaReserva(Double.parseDouble(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

    @GetMapping("/cantidad")
    public List<CantidadRvDTO> cantidaReserva() {
        List<String[]> lista = rS.cantidadService();
        List<CantidadRvDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            CantidadRvDTO dto = new CantidadRvDTO();
            dto.setNombre(columna[0]);
            dto.setCantidadReserva(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

    @GetMapping("/gananciaspromociones")
    public List<GananciasPromosDTO> gananciasPorPromos() {
        List<String[]> lista = rS.GananciasPorPromociones();
        List<GananciasPromosDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            GananciasPromosDTO dto = new GananciasPromosDTO();
            dto.setNombrePromocion(columna[0]);
            dto.setGanancia(Float.parseFloat(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }

    @GetMapping("/analisisservicios")
    public List<AnalisisServiciosDTO> analisisDeLosServicios() {
        List<String[]> lista = rS.AnalisisServicios();
        List<AnalisisServiciosDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            AnalisisServiciosDTO dto = new AnalisisServiciosDTO();
            dto.setNombreServicio(columna[0]);
            dto.setRecaudadoPorServicio(Float.parseFloat(columna[1]));
            dto.setCantidadServicios(Integer.parseInt(columna[2]));

            listaDTO.add(dto);
        }
        return listaDTO;
    }

    @GetMapping("/cantidadcentrosmedicos")
    public List<CantidadRsCDTO> cantidaReservac() {
        List<String[]> lista = rS.cantidadc();
        List<CantidadRsCDTO> listaDTO = new ArrayList<>();
        for (String[] columna : lista) {
            CantidadRsCDTO dto = new CantidadRsCDTO();
            dto.setNombre(columna[0]);
            dto.setCantidad(Integer.parseInt(columna[1]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
