package com.nhnacademy.customerservice.repository;

import com.nhnacademy.customerservice.domain.Admin;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository("AdminRepository")
public class AdminRepositoryImpl implements AdminRepository {
    private final Map<String, Admin> adminMap = new HashMap<>();

    @Override
    public boolean exists(String id) {
        return adminMap.containsKey(id);
    }

    @Override
    public boolean matches(String id, String password) {
        return Optional.ofNullable(getAdmin(id))
                .map(user -> user.getPassword().equals(password))
                .orElse(false);
    }

    @Override
    public Admin getAdmin(String id) {
        return exists(id) ? adminMap.get(id) : null;
    }

    public String getName(String id) {
        return adminMap.get(id).getName();
    }

    @Override
    public Admin addAdmin(String name, String id, String password) {

        Admin admin = Admin.create(name, id, password);

        adminMap.put(id, admin);

        return admin;
    }


}
