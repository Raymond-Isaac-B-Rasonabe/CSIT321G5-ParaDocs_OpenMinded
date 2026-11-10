package com.csit321g5.paradocs.openminded.controller;

import com.csit321g5.paradocs.openminded.entity.Admin;
import com.csit321g5.paradocs.openminded.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
@CrossOrigin
public class AdminController {

    @Autowired
    AdminService service;

    @PostMapping
    public Admin postAdmin(@RequestBody Admin admin) {
        return service.postAdmin(admin);
    }

    @GetMapping
    public List<Admin> getAllAdmin() {
        return service.getAllAdmin();
    }

    @GetMapping("/{id}")
    public Admin getAdminById(@PathVariable Long id) {
        return service.getAdminById(id);
    }

    @PutMapping("/{id}")
    public Admin putAdmin(@PathVariable Long id, @RequestBody Admin admin) {
        return service.putAdmin(id, admin);
    }

    @DeleteMapping("/{id}")
    public String deleteAdmin(@PathVariable Long id) {
        return service.deleteAdmin(id);
    }
}
