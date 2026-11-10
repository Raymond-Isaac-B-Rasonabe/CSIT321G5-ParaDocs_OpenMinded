package com.csit321g5.paradocs.openminded.service;

import com.csit321g5.paradocs.openminded.entity.Admin;
import com.csit321g5.paradocs.openminded.repository.AdminRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AdminService {

    @Autowired
    AdminRepository repo;

    // CREATE
    public Admin postAdmin(Admin admin) {
        return repo.save(admin);
    }

    // READ ALL
    public List<Admin> getAllAdmin() {
        return repo.findAll();
    }

    // READ ONE
    public Admin getAdminById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Admin " + id + " not found"));
    }

    // UPDATE
    public Admin putAdmin(Long id, Admin newDetails) {
        Admin existing = getAdminById(id);
        BeanUtils.copyProperties(newDetails, existing, "id");
        return repo.save(existing);
    }

    // DELETE
    public String deleteAdmin(Long id) {
        if (!repo.existsById(id)) {
            throw new NoSuchElementException("Admin " + id + " not found");
        }
        repo.deleteById(id);
        return "Admin " + id + " deleted";
    }
}
