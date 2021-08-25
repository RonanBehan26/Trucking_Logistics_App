package com.trucking.logistics.dto;

import com.trucking.logistics.entites.User;
import com.trucking.logistics.entites.UserWallet;

public class UserAndWalletDTO {

    private User user;

    private UserWallet userWallet;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserWallet getUserWallet() {
        return userWallet;
    }

    public void setUserWallet(UserWallet userWallet) {
        this.userWallet = userWallet;
    }
}
