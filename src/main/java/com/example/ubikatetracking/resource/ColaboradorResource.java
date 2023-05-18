package com.example.ubikatetracking.resource;

import com.example.ubikatetracking.model.Colaborador;
import com.example.ubikatetracking.model.Compania;
import com.example.ubikatetracking.model.Results;
import com.example.ubikatetracking.service.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ColaboradorResource {

    @Autowired
    ColaboradorService colaboradorService;

    @PostMapping("/colaborador/agregar")
    public String crearColaborador(@RequestBody Colaborador colaborador) {
        return colaboradorService.agregarColaborador(colaborador);
    }

    @PostMapping("/colaborador/actualizar")
    public String actualizarCompania(@RequestBody Colaborador colaborador) {
        return colaboradorService.actualizarColaborador(colaborador);
    }

    @GetMapping("/colaborador/obtener/{id}")
    public Colaborador obtenerColaboradorPorId(@PathVariable("id") String id) {
        return colaboradorService.obtenerColaboradorPorId(id);
    }

    @PutMapping("/colaborador/eliminar/{id}")
    public String eliminarColaborador(@PathVariable("id") String id) {
        return colaboradorService.eliminarColaborador(id);
    }

    @GetMapping("/colaborador/obtener")
    public Results obtenerColaboradores() {
        return colaboradorService.obtenerColaboradores();
    }
}
