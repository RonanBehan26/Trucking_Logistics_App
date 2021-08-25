package com.trucking.logistics.repositories;

import com.trucking.logistics.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByUserName(String userName);

    List<User> findUserByRoleId(Long roleId); //finds all users with the same role id

    List<User> findByUserNameAndPassword(String userName, String password);

    //One to many
    Optional<User> findById(Long id);

}
