package com.bank.BankManagementApplication;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@RestController
@RequestMapping("/creditCard")
public class CreditCardController {
    private final static Logger lOGGER = Logger.getLogger(CreditCardService.class);
    @Autowired
    private CreditCardService creditCardService;

    @GetMapping
    public String defaultMethod() {
        lOGGER.info("Default page");
        return "This is Credit Card Details Page";
    }

    @PostMapping(value = "/addCard")
    public String addCreditCardDetails(@RequestBody CreditCard creditCard) {
        lOGGER.info("Added new credit card details " + creditCard);
        String msg = "\nThis method is used for adding new credit card";
        FileCreation(msg);

        creditCardService.addCreditCard(creditCard);
        return "Credit Card details added successfully";
    }

    @GetMapping("/creditCards")
    public List<CreditCard> findAllCreditCards() {
        lOGGER.info("Getting details of all the Credit cards");
        String msg = "\nThis method is used for getting record of all the credit cards";
        FileCreation(msg);

        return creditCardService.getCreditCards();
    }

    @GetMapping(value = "/getCardById/{id}")
    public Optional<CreditCard> findById(@PathVariable int id) {
        lOGGER.info("Get credit card details " + id);

        String msg = "\nThis method is used for getting credit card details by id";
        FileCreation(msg);
        return creditCardService.getCreditCardById(id);
    }

    @PutMapping(value = "/update")
    public CreditCard updateCreditCard(@RequestBody CreditCard creditCard) {
        lOGGER.info("Update Credit Card Details " + creditCard);

        String msg = "\nThis method is used for updating the credit card details";
        FileCreation(msg);
        return creditCardService.updateCreditCard(creditCard);
    }


    public void FileCreation(String msg) {
        try {
            File myObj = new File("F:\\FileProject\\NewFile.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            FileWriter myWriter = new FileWriter("F:\\FileProject\\NewFile.txt",true);
            myWriter.write(msg);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @GetMapping("/log")
    private String ReadFile()
    {
        try
        {
            File myObj = new File("F:\\FileProject\\NewFile.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine())
            {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return null;
    }
}
