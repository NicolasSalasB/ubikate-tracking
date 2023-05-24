package com.example.ubikatetracking.service.impl;

import com.example.ubikatetracking.model.Colaborador;
import com.example.ubikatetracking.model.ColaboradorPasswordResponse;
import com.example.ubikatetracking.model.ColaboradorResponse;
import com.example.ubikatetracking.model.Results;
import com.example.ubikatetracking.repository.ColaboradorRepository;
import com.example.ubikatetracking.service.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColaboradorServiceImpl implements ColaboradorService {

    @Autowired
    ColaboradorRepository colaboradorRepository;

    @Override
    public String agregarColaborador(Colaborador colaborador) {
        return colaboradorRepository.save(colaborador);
    }

    @Override
    public ColaboradorResponse actualizarColaborador(String id, Colaborador colaborador) {
        return colaboradorRepository.update(id, colaborador);
    }

    @Override
    public Colaborador obtenerColaboradorPorId(String id) {
        return colaboradorRepository.getById(id);
    }

    @Override
    public String eliminarColaborador(String id) {
        return colaboradorRepository.delete(id);
    }

    @Override
    public Results obtenerColaboradores() {
        return colaboradorRepository.getAll();
    }

    @Override
    public ColaboradorPasswordResponse actualizarPasswordColaborador(String id, Colaborador colaborador) {
        return colaboradorRepository.updatePassword(id, colaborador);
    }
}
