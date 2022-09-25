package org.example.services;

import org.example.models.Bank;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class XMLHandler {
    protected String path;


    public XMLHandler(String path) {
        this.path = path;
    }


}
