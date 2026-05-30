package com.learning.first.repository;

import com.learning.first.Service.CreateWallet;
import com.learning.first.modal.CreateWalletModal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreateWalletRepository extends JpaRepository<CreateWalletModal,String> {
}
