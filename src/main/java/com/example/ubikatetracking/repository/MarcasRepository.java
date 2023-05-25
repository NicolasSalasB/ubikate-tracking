package com.example.ubikatetracking.repository;

import com.example.ubikatetracking.model.Results;
import com.example.ubikatetracking.request.MarcaFechasRequest;

public interface MarcasRepository {

    Results getAll(MarcaFechasRequest marcaFechasRequest);
}
