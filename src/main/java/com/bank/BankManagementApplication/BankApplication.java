package com.bank.BankManagementApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.log4j.BasicConfigurator;

@SpringBootApplication
public class BankApplication
{
    public static void main(String[] args)
    {
        BasicConfigurator.configure();
        SpringApplication.run(BankApplication.class, args);
    }
}