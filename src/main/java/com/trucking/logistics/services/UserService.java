package com.trucking.logistics.services;

import com.trucking.logistics.dto.UserAndBookingDTO;
import com.trucking.logistics.dto.UserAndTripsDTO;
import com.trucking.logistics.dto.UserAndWalletDTO;
import com.trucking.logistics.entites.User;

import java.util.List;

public interface UserService {

    User findById(Long id);

    List<User> findAll();

    List<User> findByUserName(String userName);

    List<User> findUserByRoleId(Long roleId);

    List<User> findUserByUserNameAndPassword(String userName, String password);

    Long createUser(User user);

    boolean exists(Long id);

    void updateUser(User user, Long id);

    void deleteUser(Long id);

    UserAndWalletDTO getUserAndUserWallet(Long id);

    UserAndBookingDTO getUserAndUserBookings(Long id);

    UserAndTripsDTO getUserAndUserTrips(Long id);

}
