package com.nhnacademy.customerservice.controller;


import com.nhnacademy.customerservice.repository.AdminRepository;
import com.nhnacademy.customerservice.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    private final UserRepository userRepository;

    private final AdminRepository adminRepository;

    public LoginController(UserRepository userRepository, AdminRepository adminRepository) {
        this.userRepository = userRepository;
        this.adminRepository = adminRepository;
    }

    @GetMapping("/login")
    public String login(HttpServletRequest req) {
        HttpSession session = req.getSession();
        if (session.getAttribute("userLogin") != null) {
            session.setAttribute("id", session);
            return "thymeleaf/userMenu";
        } else if (session.getAttribute("adminLogin") != null) {
            session.setAttribute("id", session);
            return "thymeleaf/adminMenu";
        } else {
            return "thymeleaf/loginForm";
        }
    }

    @PostMapping("/login")
    public String doLogin(@RequestParam("id") String id,
                          @RequestParam("pwd") String pwd,
                          HttpServletRequest request
    ) {
        HttpSession session = request.getSession(true);
        if (userRepository.matches(id, pwd)) {
            session.setAttribute("userLogin", id);
            return "thymeleaf/userMenu";
        } else if (adminRepository.matches(id, pwd)) {
            session.setAttribute("adminLogin", id);
            return "thymeleaf/adminMenu";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/logout")
    private String expireCookie(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }

}
