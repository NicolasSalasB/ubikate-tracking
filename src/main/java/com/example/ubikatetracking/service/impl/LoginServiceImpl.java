package com.example.ubikatetracking.service.impl;

import com.example.ubikatetracking.model.Colaborador;
import com.example.ubikatetracking.model.UserLogin;
import com.example.ubikatetracking.repository.ColaboradorRepository;
import com.example.ubikatetracking.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    ColaboradorRepository colaboradorRepository;

    private BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();

    @Override
    public Colaborador userLogin(UserLogin userLogin) {

        Colaborador colaborador = colaboradorRepository.getByUser(userLogin.getUsuario());

        if (colaborador == null){
            return null;
        }

        if (!passwordEncryptor.checkPassword(userLogin.getContrasena(), colaborador.getClave())){
            return null;
        }

        return colaborador;
    }
}
