package com.example.ubikatetracking.repository;

import com.example.ubikatetracking.model.Compania;

public interface CompaniaRepository {
    String save(Compania compania);
    String delete(String id);
}
