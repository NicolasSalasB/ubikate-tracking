package com.example.ubikatetracking.repository;

import com.example.ubikatetracking.model.Colaborador;
import com.example.ubikatetracking.model.ColaboradorPasswordResponse;
import com.example.ubikatetracking.model.ColaboradorResponse;
import com.example.ubikatetracking.model.Results;

public interface ColaboradorRepository {

    String save(Colaborador colaborador);
    ColaboradorResponse update(String id, Colaborador colaborador);
    Colaborador getById(String id);
    Colaborador getByUser(String userColaborador);
    String delete(String id);
    Results getAll();
    ColaboradorPasswordResponse updatePassword(String id, Colaborador colaborador);
}
