package com.trucking.logistics.services;

import com.trucking.logistics.entites.UserWallet;

import java.util.List;

public interface UserWalletService {

    Long createUserWallet(UserWallet userWallet);

    void updateUserWallet(UserWallet userWallet, Long id);

    void deleteUserWallet(Long id);

    List<UserWallet> findAll();

    UserWallet findById(Long id);

    UserWallet findByUserId(Long userId);
}
