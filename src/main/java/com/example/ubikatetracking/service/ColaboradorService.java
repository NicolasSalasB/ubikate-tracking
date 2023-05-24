package com.example.ubikatetracking.service;

import com.example.ubikatetracking.model.Colaborador;
import com.example.ubikatetracking.model.ColaboradorPasswordResponse;
import com.example.ubikatetracking.model.ColaboradorResponse;
import com.example.ubikatetracking.model.Results;

public interface ColaboradorService {
    String agregarColaborador(Colaborador colaborador);
    ColaboradorResponse actualizarColaborador(String id, Colaborador colaborador);
    Colaborador obtenerColaboradorPorId(String id);
    String eliminarColaborador(String id);
    Results obtenerColaboradores();
    ColaboradorPasswordResponse actualizarPasswordColaborador(String id, Colaborador colaborador);
}
