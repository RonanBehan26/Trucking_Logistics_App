package com.trucking.logistics.serviceImpl;

import com.trucking.logistics.entites.UserWallet;
import com.trucking.logistics.repositories.UserWalletRepository;
import com.trucking.logistics.services.UserWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserWalletServiceImpl implements UserWalletService {

    @Autowired
    private UserWalletRepository userWalletRepository;

    @Override
    public Long createUserWallet(UserWallet userWallet) {
        return userWalletRepository.save(userWallet).getId();
    }

    @Override
    public void updateUserWallet(UserWallet userWallet, Long id) {
        UserWallet userWalletFromDb = findById(id);
        //System.out.println(userFromDb.toString());
        userWalletFromDb.setUserId(userWallet.getUserId());
        userWalletFromDb.setBalance(userWallet.getBalance());
        userWalletRepository.save(userWalletFromDb);
    }

    @Override
    public void deleteUserWallet(Long id) {
        userWalletRepository.deleteById(id);
    }

    @Override
    public List<UserWallet> findAll() {
        return userWalletRepository.findAll();
    }

    @Override
    public UserWallet findById(Long id) {
        Optional<UserWallet> userWallet = userWalletRepository.findById(id);
        if(userWallet.isPresent()){
            return userWallet.get();
        }
        return null;
    }

    @Override
    public UserWallet findByUserId(Long userId) {
        return userWalletRepository.findByUserId(userId);
    }
}
