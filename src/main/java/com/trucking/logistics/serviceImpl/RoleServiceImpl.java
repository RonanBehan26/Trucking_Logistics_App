package com.trucking.logistics.serviceImpl;

import com.trucking.logistics.entites.Role;
import com.trucking.logistics.repositories.RoleRepository;
import com.trucking.logistics.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findById(Long id) {//
        Optional<Role> role = roleRepository.findById(id);
        if(role.isPresent()){
            return role.get();
        }
        return null;
    }

    @Override
    public Role findByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public Long createRole(Role role) {//works
        return roleRepository.save(role).getId();
    }

    @Override
    public boolean exists(Long id) {
        return false;
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public void updateRole(Role role, Long id) {
        Role roleFromDb = roleRepository.findById(id).get();
        //System.out.println(userFromDb.toString());
        roleFromDb.setName(role.getName());
        roleRepository.save(roleFromDb);
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }
}
