package com.nhnacademy.customerservice.controller;


import com.nhnacademy.customerservice.domain.Admin;
import com.nhnacademy.customerservice.domain.User;
import com.nhnacademy.customerservice.exception.UserNotFoundException;
import com.nhnacademy.customerservice.repository.AdminRepository;
import com.nhnacademy.customerservice.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final AdminRepository adminRepository;

    public AdminController(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @ModelAttribute("admin")
    public Admin getAdmin(@PathVariable("adminId") String adminId) {
        Admin admin = adminRepository.getAdmin(adminId);
        if (Objects.isNull(admin)) {
            throw new UserNotFoundException();
        }

        return admin;
    }
}

