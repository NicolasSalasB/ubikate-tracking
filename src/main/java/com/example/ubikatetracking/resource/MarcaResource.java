package com.example.ubikatetracking.resource;

import com.example.ubikatetracking.model.Results;
import com.example.ubikatetracking.request.MarcaFechasRequest;
import com.example.ubikatetracking.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MarcaResource {

    @Autowired
    MarcaService marcaService;

    @PostMapping("/marca/obtener")
    public Results obtenerMarcas(@RequestBody MarcaFechasRequest marcaFechasRequest) {
        return marcaService.obtenerMarcas(marcaFechasRequest);
    }
}
