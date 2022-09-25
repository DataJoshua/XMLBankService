package org.example;

import org.example.models.Bank;
import org.example.models.Transaction;
import org.example.models.User;
import org.example.services.XMLHandlerBank;
import org.example.services.XMLHandlerTransaction;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws JAXBException, FileNotFoundException {


        User user1 = new User("joshua", "123124323");

        String pathXMLAssets = "src/main/java/org/example/xmlAssets/";
        ArrayList<User> users = new ArrayList<>();
        users.add(user1);

        Bank sber = new Bank("scerbank", users);

        XMLHandlerBank xmlHandlerBank = new XMLHandlerBank(pathXMLAssets, sber);

        Transaction transaction1 = new Transaction(user1, sber, 1000, "usd");

        XMLHandlerTransaction xmlHandlerTransaction = new XMLHandlerTransaction(pathXMLAssets, transaction1);

        xmlHandlerTransaction.toXML("transaction2.xml");
        xmlHandlerBank.toXML("bancoss.xml");
    }



}