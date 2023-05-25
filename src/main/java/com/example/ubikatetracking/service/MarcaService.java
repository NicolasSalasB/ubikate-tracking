package com.example.ubikatetracking.service;

import com.example.ubikatetracking.model.Results;
import com.example.ubikatetracking.request.MarcaFechasRequest;

public interface MarcaService {

    Results obtenerMarcas(MarcaFechasRequest marcaFechasRequest);
}
