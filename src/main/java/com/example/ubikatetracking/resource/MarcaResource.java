package com.example.ubikatetracking.resource;

import com.example.ubikatetracking.model.Results;
import com.example.ubikatetracking.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MarcaResource {

    @Autowired
    MarcaService marcaService;

    @GetMapping("/marca/obtener")
    public Results obtenerMarcas() {
        return marcaService.obtenerMarcas();
    }
}
