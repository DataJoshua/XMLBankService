package org.example;

import org.example.models.Bank;
import org.example.models.User;
import org.example.services.XMLHandlerBank;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws JAXBException, FileNotFoundException {


        User user1 = new User("joshua", "123124323");

        ArrayList<User> users = new ArrayList<>();
        users.add(user1);

        Bank sber = new Bank("scerbank", users);

        XMLHandlerBank xmlHandlerBank = new XMLHandlerBank("src/main/java/org/example/xmlAssets/");

        xmlHandlerBank.toXML(sber, "bancos.xml");
        Bank ban1 = xmlHandlerBank.fromXML("banco.xml");

    }



}