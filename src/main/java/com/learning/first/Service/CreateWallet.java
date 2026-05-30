package com.learning.first.Service;

import com.learning.first.Interfaces.CreateWalletInterface;
import com.learning.first.dto.CreateWalletDto;
import com.learning.first.dto.CreateWalletResponseDto;
import com.learning.first.exception.WalletCreationFailedException;
import com.learning.first.modal.CreateWalletModal;
import com.learning.first.repository.CreateWalletRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("CreateWallet")
public class CreateWallet implements CreateWalletInterface {
    @Autowired
    CreateWalletRepository repo;


    @Override
    @Transactional
    public CreateWalletResponseDto CreateWallet(CreateWalletDto request)
    {
        String accno;
        try {
             accno = UUID.randomUUID().toString();

            CreateWalletModal newRecord = new CreateWalletModal();

            newRecord.setAccountNo(accno);
            newRecord.setName(request.getName());
            newRecord.setAdress(request.getAddress());
            newRecord.setPhoneno(request.getPhoneNo());
            newRecord.setAmount(0.0);
            repo.save(newRecord);
        }catch(Exception ex)
        {
            throw new WalletCreationFailedException("Unknown exception occured. Unable to create the wallet ");
        }


        return new CreateWalletResponseDto(accno,request.getName(),
                request.getGender()
                ,request.getAddress()
                ,request.getPhoneNo()
                ,0.0
                ,"CREATED SUCCESSFULLY");
    }




}
