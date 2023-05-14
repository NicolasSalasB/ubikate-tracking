package com.example.ubikatetracking.service.impl;

import com.example.ubikatetracking.model.Compania;
import com.example.ubikatetracking.repository.CompaniaRepository;
import com.example.ubikatetracking.service.CompaniaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompaniaServiceImpl implements CompaniaService {
    @Autowired
    CompaniaRepository companiaRepository;
    @Override
    public String agregarCompania(Compania compania) {
        return companiaRepository.save(compania);
    }

    @Override
    public String actualizarCompania(Compania compania) {
        return companiaRepository.update(compania);
    }

    @Override
    public Compania obtenerCompaniaPorId(String id) {
        return companiaRepository.getById(id);
    }

    @Override
    public String eliminarCompania(String id) {
        return companiaRepository.delete(id);
    }
}
