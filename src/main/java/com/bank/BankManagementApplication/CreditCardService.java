package com.bank.BankManagementApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditCardService
{
    @Autowired
    private CreditCardRepository creditCardRepository;
    public void addCreditCard(CreditCard card)
    {
        creditCardRepository.save(card);
    }
    public Optional<CreditCard> getCreditCardById(int id)
    {
        return creditCardRepository.findById(id);
    }

    public List<CreditCard> getCreditCards()
    {
        return creditCardRepository.findAll();
    }

    public CreditCard updateCreditCard(CreditCard creditCard)
    {
        return creditCardRepository.save(creditCard);
    }
}
