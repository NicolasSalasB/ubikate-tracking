package com.example.ubikatetracking.resource;

import com.example.ubikatetracking.model.Colaborador;
import com.example.ubikatetracking.model.UserLogin;
import com.example.ubikatetracking.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoginResource {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public Colaborador userLogin(@RequestBody UserLogin userLogin) {
        return loginService.userLogin(userLogin);
    }
}
