package com.example.ubikatetracking.resource;

import com.example.ubikatetracking.model.Compania;
import com.example.ubikatetracking.service.CompaniaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CompaniaResource {

    @Autowired
    CompaniaService companiaService;
    @PostMapping("/compania/agregar")
    public String crearCompania(@RequestBody Compania compania) {
        return companiaService.agregarCompania(compania);
    }

    @PostMapping("/compania/actualizar")
    public String actualizarCompania(@RequestBody Compania compania) {
        return companiaService.actualizarCompania(compania);
    }

    @GetMapping("/compania/obtener/{id}")
    public Compania obtenerCompaniaPorId(@PathVariable("id") String id) {
        return companiaService.obtenerCompaniaPorId(id);
    }

    @PutMapping("/compania/eliminar/{id}")
    public String eliminarCompania(@PathVariable("id") String id) {
        return companiaService.eliminarCompania(id);
    }
}
