package com.trucking.logistics.controllers;

import com.trucking.logistics.mapper.CorvidMapper;
import com.trucking.logistics.model.UserPrincipal;
import com.trucking.logistics.model.UserToken;
import com.trucking.logistics.serviceImpl.JWTTokenProviderService;
import com.trucking.logistics.serviceImpl.UserAuthDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.trucking.logistics.util.ConstantUtil.*;

@RestController
@RequestMapping("/user/api/")
public class UserAndAuthenticationController {

    @Autowired
    private CorvidMapper corvidMapper;

    @Autowired
    private JWTTokenProviderService jwtTokenProviderService;

    @Autowired
    UserAuthDetailsService userAuthDetailsService;

    @Autowired
    UserToken userToken;

    @Autowired
    private UserAuthDetailsService userDetailsService;

    private static final Logger LOGGER = LoggerFactory.getLogger(UserAndAuthenticationController.class);

    @GetMapping("get_access_token/{user_name}")
    public String getUserToken(@PathVariable("user_name") String userName){

        try {
            LOGGER.info("Request received for Access Token against name : " + userName);

            if (userName == null || userName.isEmpty()) {
                return "FAILED!! Invalid request";
            }

            UserPrincipal userDetails = userDetailsService.loadUserByUsername(userName);

            String token = jwtTokenProviderService.generateAccessToken(userName, userDetails.getAuthorities());

            userToken.setAccess_token(token);
            userToken.setToken_type(BEARER);
            userToken.setMessage(SUCCESS);

            LOGGER.info("Access Token Created : ", token);

        }catch (Exception ex){
            return ex.getMessage();
        }
        return corvidMapper.convertObjectToJson(userToken);
    }

    @GetMapping("users/list")
    public String getUserList() {
        try {
            return userLists.keySet().toString();
        }catch (Exception ex){
            return ex.getMessage();
        }
    }
}
