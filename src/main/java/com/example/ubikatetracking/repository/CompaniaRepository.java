package com.example.ubikatetracking.repository;

import com.example.ubikatetracking.model.Compania;

public interface CompaniaRepository {
    String save(Compania compania);
    String update(Compania compania);
    Compania getById(String id);
    String delete(String id);
}
