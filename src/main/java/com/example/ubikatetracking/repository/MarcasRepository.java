package com.example.ubikatetracking.repository;

import com.example.ubikatetracking.model.Results;

public interface MarcasRepository {

    Results getMarcasByFilters(String fechaInicio, String fechaFin, String nombre);
}
