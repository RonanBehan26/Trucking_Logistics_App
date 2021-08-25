package com.trucking.logistics.serviceImpl;

import com.trucking.logistics.model.User;
import com.trucking.logistics.model.UserPrincipal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.trucking.logistics.util.ConstantUtil.USER;
import static com.trucking.logistics.util.ConstantUtil.userLists;

@Service
public class UserAuthDetailsService implements UserDetailsService {

    @Autowired
    public User user;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserAuthDetailsService.class);


    public UserPrincipal loadUserByUsernameForFilter(String userName) {

        String key = this.findUserFromData(userName); //find if user exist in cache

        if (key == null) {
            throw new UsernameNotFoundException("Invalid Token");
        }

        user.setClientId(key);
        user.setRole("USER");

        return UserPrincipal.create(user);
    }

    @Override
    public UserPrincipal loadUserByUsername(String userName) {

        String key = this.findUserFromData(userName);

        if (key == null) {
            LOGGER.info("New User with name : " + userName);
            key = userName;
        }else{
            try {
               TimeUnit.SECONDS.sleep(1); //to put gap of 1 sec in new token with same username
            } catch (InterruptedException e) {
                LOGGER.error(e.getMessage());
            }
        }

        user.setClientId(key);
        user.setRole(USER);

        return UserPrincipal.create(user);
    }

    public String findUserFromData(String userName) {

        return userLists.entrySet().stream()
                .filter(e -> e.getKey().equalsIgnoreCase(userName))
                .map(Map.Entry::getKey).findFirst()
                .orElse(null);

    }

}
