package com.learning.first.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name ="Payment_Track")
public class PaymentTrack {

    @Id
    int TransactionId;

    @Column
    String Status;

    @Column
    String Mode;

    @Column
    Double Amount;
}
