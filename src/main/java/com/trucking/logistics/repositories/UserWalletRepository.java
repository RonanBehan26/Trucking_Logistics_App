package com.trucking.logistics.repositories;

import com.trucking.logistics.entites.UserWallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserWalletRepository extends JpaRepository<UserWallet, Long> {

    UserWallet findByUserId(Long userId);
}
