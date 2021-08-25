package com.trucking.logistics.controllers;

import com.trucking.logistics.entites.Role;
import com.trucking.logistics.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/roles")//works
    public List<Role> getAllRoles() {
        return roleService.findAll();
    }

    @GetMapping(value = "/role/{id}")
    public Role getRoleById(@PathVariable("id") Long id) {
        return roleService.findById(id);
    }

    @GetMapping(value = "/role/{name}")
    public Role getRoleByName(@PathVariable("name") String name) {
        return roleService.findByName(name);
    }

    @PostMapping("/role")//works
    public Long createRole(@Validated @RequestBody Role role) {
        return roleService.createRole(role);
    }

    @PutMapping("/role/{id}")//works
    public void updateRole(@RequestBody Role role, @PathVariable Long id) {
        roleService.updateRole(role, id);
    }

    @DeleteMapping("/role/{id}")//works
    public void deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
    }

}
