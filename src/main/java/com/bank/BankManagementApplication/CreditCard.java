package com.bank.BankManagementApplication;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table( name = "CreditCard")
public class CreditCard
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    int accountNumber;
    String customerId;
    long cardNumber;
    String validity;
    int cvv;
    String cardHolderName;

}