package com.learning.first.config;

import com.learning.first.modal.CreateWalletModal;
import com.learning.first.repository.CreateWalletRepository;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final CreateWalletRepository walletRepository;

    public DataSeeder(CreateWalletRepository walletRepository) {

        this.walletRepository = walletRepository;
    }

    @Override
    public void run(String @NonNull ... args) throws Exception {

        if (walletRepository.count() == 0) {
            CreateWalletModal demoWallet = new CreateWalletModal();
            demoWallet.setAccountNo("ACC12345");
            demoWallet.setName("John Doe");
            demoWallet.setAdress("123 Spring Street");
            demoWallet.setPhoneno("9876543210");
            demoWallet.setAmount(500.0);
            walletRepository.save(demoWallet);
        }
    }
}
