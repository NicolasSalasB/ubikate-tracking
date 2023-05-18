package com.example.ubikatetracking.service;

import com.example.ubikatetracking.model.Colaborador;
import com.example.ubikatetracking.model.Results;

public interface ColaboradorService {
    String agregarColaborador(Colaborador colaborador);
    String actualizarColaborador(Colaborador colaborador);
    Colaborador obtenerColaboradorPorId(String id);
    String eliminarColaborador(String id);
    Results obtenerColaboradores();
}
