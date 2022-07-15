package com.hashkart.payment.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PAYMENT")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PAYMENT_PAYMENT_ID_SEQ")
    @SequenceGenerator(
            name = "PAYMENT_PAYMENT_ID_SEQ",
            allocationSize = 1
    )
    @Column(name = "payment_id")
    private int payment_id;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "payment_status")
    private String payment_status;

    @Column(name = "transaction_id")
    private String transaction_id;

    @Column(name = "amount")
    private double amount;

}
