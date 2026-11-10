package com.csit321g5.paradocs.openminded.service;

import com.csit321g5.paradocs.openminded.entity.LoginActivity;
import com.csit321g5.paradocs.openminded.repository.LoginActivityRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LoginActivityService {

    @Autowired
    LoginActivityRepository repo;

    // CREATE
    public LoginActivity postLoginActivity(LoginActivity loginActivity) {
        return repo.save(loginActivity);
    }

    // READ ALL
    public List<LoginActivity> getAllLoginActivity() {
        return repo.findAll();
    }

    // READ ONE
    public LoginActivity getLoginActivityById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("LoginActivity " + id + " not found"));
    }

    // UPDATE
    public LoginActivity putLoginActivity(Long id, LoginActivity newDetails) {
        LoginActivity existing = getLoginActivityById(id);
        BeanUtils.copyProperties(newDetails, existing, "id");
        return repo.save(existing);
    }

    // DELETE
    public String deleteLoginActivity(Long id) {
        if (!repo.existsById(id)) {
            throw new NoSuchElementException("LoginActivity " + id + " not found");
        }
        repo.deleteById(id);
        return "LoginActivity " + id + " deleted";
    }
}
