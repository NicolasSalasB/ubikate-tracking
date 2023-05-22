package com.example.ubikatetracking.service;

import com.example.ubikatetracking.model.Colaborador;
import com.example.ubikatetracking.model.UserLogin;

public interface LoginService {

    Colaborador userLogin(UserLogin userLogin);
}
