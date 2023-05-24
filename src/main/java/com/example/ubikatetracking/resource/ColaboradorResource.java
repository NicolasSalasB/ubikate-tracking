package com.example.ubikatetracking.resource;

import com.example.ubikatetracking.model.*;
import com.example.ubikatetracking.service.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ColaboradorResource {

    @Autowired
    ColaboradorService colaboradorService;

    @PostMapping("/colaborador/agregar")
    public String crearColaborador(@RequestBody Colaborador colaborador) {
        return colaboradorService.agregarColaborador(colaborador);
    }

    @PostMapping("/colaborador/actualizar/{id}")
    public ColaboradorResponse actualizarColaborador(@PathVariable("id") String id, @RequestBody Colaborador colaborador) {
        return colaboradorService.actualizarColaborador(id, colaborador);
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

    @PostMapping("/colaborador/actualizar/password/{id}")
    public ColaboradorPasswordResponse actualizarColaboradorPassword(@PathVariable("id") String id, @RequestBody Colaborador colaborador) {
        return colaboradorService.actualizarPasswordColaborador(id, colaborador);
    }
}
