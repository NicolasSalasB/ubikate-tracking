package com.example.ubikatetracking.repository;

import com.example.ubikatetracking.model.Colaborador;
import com.example.ubikatetracking.model.Results;

public interface ColaboradorRepository {

    String save(Colaborador colaborador);
    String update(Colaborador colaborador);
    Colaborador getById(String id);
    Colaborador getByUser(String userColaborador);
    String delete(String id);
    Results getAll();
}
