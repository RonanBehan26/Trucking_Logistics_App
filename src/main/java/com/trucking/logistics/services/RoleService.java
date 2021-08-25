package com.trucking.logistics.services;

import com.trucking.logistics.entites.Role;

import java.util.List;

public interface RoleService {

    Role findById(Long id);

    Role findByName(String name);

    Long createRole(Role role);

    boolean exists(Long id);

    List<Role> findAll();

    void updateRole(Role role, Long id);

    void deleteRole(Long id);
}
