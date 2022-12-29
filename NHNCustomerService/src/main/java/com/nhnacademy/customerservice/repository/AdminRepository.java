package com.nhnacademy.customerservice.repository;


import com.nhnacademy.customerservice.domain.Admin;

public interface AdminRepository {
    boolean exists(String id);

    boolean matches(String id, String password);

    Admin getAdmin(String id);

    Admin addAdmin(String name, String id, String password);

    String getName(String id);
}
