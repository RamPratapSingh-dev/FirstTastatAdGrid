package com.learning.first.modal;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tools.jackson.databind.util.UniqueId;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "Wallets")
@NoArgsConstructor
public class CreateWalletModal {

    @Id
    @Column
    String accountNo;

    @Column
    String name;

    @Column
    String adress;

    @Column
    String phoneno;

    @Column
    Double amount;
}
