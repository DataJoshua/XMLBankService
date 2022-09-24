package org.example.services;

import org.example.models.Bank;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class XMLHandlerBank {

    private String path;

    public XMLHandlerBank(String path) {
        this.path = path;
    }

    public void toXML(Bank bank, String filename) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Bank.class);
        Marshaller mar= context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(bank, new File(this.path + filename));
    }


    public Bank fromXML(String fileName) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(Bank.class);
        return (Bank) context.createUnmarshaller()
                .unmarshal(new FileReader(this.path + fileName));
    }


}
