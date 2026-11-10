package com.csit321g5.paradocs.openminded.controller;

import com.csit321g5.paradocs.openminded.entity.LoginActivity;
import com.csit321g5.paradocs.openminded.service.LoginActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/login-activitys")
@CrossOrigin
public class LoginActivityController {

    @Autowired
    LoginActivityService service;

    @PostMapping
    public LoginActivity postLoginActivity(@RequestBody LoginActivity loginActivity) {
        return service.postLoginActivity(loginActivity);
    }

    @GetMapping
    public List<LoginActivity> getAllLoginActivity() {
        return service.getAllLoginActivity();
    }

    @GetMapping("/{id}")
    public LoginActivity getLoginActivityById(@PathVariable Long id) {
        return service.getLoginActivityById(id);
    }

    @PutMapping("/{id}")
    public LoginActivity putLoginActivity(@PathVariable Long id, @RequestBody LoginActivity loginActivity) {
        return service.putLoginActivity(id, loginActivity);
    }

    @DeleteMapping("/{id}")
    public String deleteLoginActivity(@PathVariable Long id) {
        return service.deleteLoginActivity(id);
    }
}
