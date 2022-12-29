package com.nhnacademy.customerservice.domain;


import lombok.Getter;
import lombok.Setter;

public class Admin {
    @Getter
    private final String name;
    @Getter
    private final String id;

    @Getter
    private final String password;

    public static Admin create(String name, String id, String password) {
        return new Admin(name, id, password);
    }

    private Admin(String name, String id, String password) {
        this.id = id;
        this.password = password;
        this.name = name;
    }

    private static final String MASK = "*****";

    public static Admin constructPasswordMaskedUser(Admin admin) {
        Admin newAdmin = Admin.create(admin.name, admin.getId(), MASK);

        return newAdmin;
    }

}
