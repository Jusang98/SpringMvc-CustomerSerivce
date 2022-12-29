package com.nhnacademy.customerservice.repository;


import com.nhnacademy.customerservice.domain.User;

public interface UserRepository {
    boolean exists(String id);

    boolean matches(String id, String password);

    User getUser(String id);

    User addUser(String id, String password);

}
