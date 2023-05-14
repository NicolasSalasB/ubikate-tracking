package com.example.ubikatetracking.service;

import com.example.ubikatetracking.model.Compania;
public interface CompaniaService {

    String agregarCompania(Compania compania);
    String actualizarCompania(Compania compania);
    Compania obtenerCompaniaPorId(String id);
    String eliminarCompania(String id);
}
