package com.trucking.logistics.serviceImpl;

import com.trucking.logistics.dto.UserAndBookingDTO;
import com.trucking.logistics.dto.UserAndTripsDTO;
import com.trucking.logistics.dto.UserAndWalletDTO;
import com.trucking.logistics.entites.Booking;
import com.trucking.logistics.entites.Trips;
import com.trucking.logistics.entites.User;
import com.trucking.logistics.entites.UserWallet;
import com.trucking.logistics.repositories.UserRepository;
import com.trucking.logistics.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserWalletServiceImpl userWalletServiceImpl;

    @Autowired
    private BookingServiceImpl bookingServiceImpl;

    @Autowired
    private TripsServiceImpl tripsServiceImpl;

    @Override
    public User findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }

    @Override
    public List<User> findUserByRoleId(Long roleId) {
        return userRepository.findUserByRoleId(roleId);
    }

    @Override
    public List<User> findUserByUserNameAndPassword(String userName, String password){
        return userRepository.findByUserNameAndPassword(userName, password);
    }

    @Override
    public Long createUser(User user) {
        return userRepository.save(user).getId();
    }

    @Override
    public boolean exists(Long id) {
        return userRepository.existsById(id);
    }

    @Override
    public void updateUser(User user, Long id) {
        User userFromDb = userRepository.findById(id).get();
        //System.out.println(userFromDb.toString());
        userFromDb.setUserName(user.getUserName());
        userFromDb.setPassword(user.getPassword());
        userRepository.save(userFromDb);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserAndWalletDTO getUserAndUserWallet(Long id) {
        Optional<User> user = userRepository.findById(id);
        UserWallet wallet = userWalletServiceImpl.findByUserId(id);
        UserAndWalletDTO userAndWalletDTO = new UserAndWalletDTO();
        if(user.isPresent()){
            userAndWalletDTO.setUser(user.get());
            userAndWalletDTO.setUserWallet(wallet);
            return userAndWalletDTO;
        }
        return null;
    }

    @Override
    public UserAndBookingDTO getUserAndUserBookings(Long id) {
        UserAndBookingDTO userAndBookingDTO = new UserAndBookingDTO();
        Optional<User> user = userRepository.findById(id);
        List<Booking> bookings = bookingServiceImpl.findBookingUserId(id);
        if(user.isPresent()){
            userAndBookingDTO.setUser(user.get());
                userAndBookingDTO.setBooking(bookings);
                return userAndBookingDTO;
            }
        return null;
    }

    @Override
    public UserAndTripsDTO getUserAndUserTrips(Long id) {
        UserAndTripsDTO userAndTripsDTO = new UserAndTripsDTO();
        Optional<User> user = userRepository.findById(id);
        List<Trips> trips = tripsServiceImpl.findByUserId(id);
        if (user.isPresent()) {
            userAndTripsDTO.setUser(user.get());
                userAndTripsDTO.setTrips(trips);
                return userAndTripsDTO;
            }
        return null;
    }

}