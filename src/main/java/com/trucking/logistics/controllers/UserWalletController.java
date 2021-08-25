package com.trucking.logistics.controllers;

import com.trucking.logistics.entites.UserWallet;
import com.trucking.logistics.services.UserWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userWallet")
public class UserWalletController {

    @Autowired
    private UserWalletService userWalletService;

    @PostMapping("/userWalletAction")//works
    public Long createUserWallet(@Validated @RequestBody UserWallet userWallet) {
        return userWalletService.createUserWallet(userWallet);
    }

    @PutMapping("/userWalletAction/{id}")//works
    public void updateUserWallet(@RequestBody UserWallet userWallet, @PathVariable Long id) {
        userWalletService.updateUserWallet(userWallet, id);
    }

    @DeleteMapping("/userWalletAction/{id}")//works
    public void deleteUserWallet(@PathVariable Long id) {
        userWalletService.deleteUserWallet(id);
    }

    @GetMapping("/userWalletAction")//works
    public List<UserWallet> getAllUserWallets() {
        return userWalletService.findAll();
    }

    @GetMapping("/userWalletAction/{id}")//works
    public UserWallet getUserWallet(@PathVariable("id") Long id) {
        return userWalletService.findById(id);
    }
}
