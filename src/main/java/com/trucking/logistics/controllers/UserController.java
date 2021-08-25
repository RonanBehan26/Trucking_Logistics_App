package com.trucking.logistics.controllers;

import com.trucking.logistics.dto.UserAndBookingDTO;
import com.trucking.logistics.dto.UserAndTripsDTO;
import com.trucking.logistics.dto.UserAndWalletDTO;
import com.trucking.logistics.entites.User;
import com.trucking.logistics.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

      /**
     * Get all users list.
     *
     * @return the list
     */

    @GetMapping("/users")//works
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/user/{id}")//works
    public User getUser(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @GetMapping("/users/{userName}")//works
    public List<User> getUserName(@PathVariable("userName") String userName) {
        return userService.findByUserName(userName);
    }

    @GetMapping("/users/role/{roleId}")
    public List<User> getAllUsersByRoleId(@PathVariable("roleId") Long roleId) {
        return userService.findUserByRoleId(roleId);
    }

    @GetMapping("/userlogin")//
    public List<User> getUserNameAndPassword(@RequestBody User user) {
        return userService.findUserByUserNameAndPassword(user.getUserName(), user.getPassword());
    }

    /**
     * Create user user.
     *
     * @param user the user
     * @return the user
     */
    @PostMapping("/user")//works
    public Long createUser(@Validated @RequestBody User user) {
        return userService.createUser(user);
    }

//    //OneToManyRelationship
//    @GetMapping("/userAndTripsOneToMany/{id}")//works
//    public List<User> getUserAndTrips(@PathVariable Long id) {
//        return userService.getUserAndTrips(id);
//    }

    //DTO for user and the userwallet
    @GetMapping("/userAndWallet/{id}")//works
    public UserAndWalletDTO getUserAndUserWallet(@PathVariable Long id) {
        return userService.getUserAndUserWallet(id);
    }

    //DTO for User and booking
    @GetMapping("/userAndBooking/{id}")//works
    public UserAndBookingDTO getUserAndUserBooking(@PathVariable Long id) {
        return userService.getUserAndUserBookings(id);
    }

    //DTO for User and trip
    @GetMapping("/userAndTrips/{id}")//works
    public UserAndTripsDTO getUserAndUserTrips(@PathVariable Long id) {
        return userService.getUserAndUserTrips(id);
    }

    @PutMapping("/user/{id}")//works
    public void updateUser(@RequestBody User user, @PathVariable Long id) {
        userService.updateUser(user, id);
    }

    @DeleteMapping("/user/{id}")//works
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}
