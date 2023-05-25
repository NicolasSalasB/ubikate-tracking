package com.example.ubikatetracking.service.impl;

import com.example.ubikatetracking.model.Results;
import com.example.ubikatetracking.repository.MarcasRepository;
import com.example.ubikatetracking.request.MarcaFechasRequest;
import com.example.ubikatetracking.service.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MarcaServiceImpl implements MarcaService {

    @Autowired
    MarcasRepository marcasRepository;

    @Override
    public Results obtenerMarcas(MarcaFechasRequest marcaFechasRequest) {
        return marcasRepository.getAll(marcaFechasRequest);
    }
}
