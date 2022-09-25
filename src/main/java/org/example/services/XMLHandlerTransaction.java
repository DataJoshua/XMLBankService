package org.example.services;

import org.example.models.Bank;
import org.example.models.Transaction;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;

public class XMLHandlerTransaction extends XMLHandler {

    private Transaction transaction;
    public XMLHandlerTransaction(String path, Transaction transaction){
        super(path);
        this.transaction = transaction;

    }

    public void toXML(String filename) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Transaction.class);
        Marshaller mar= context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(transaction, new File(this.path + filename));
    }

    public void toXML(OutputStream outputStream) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Transaction.class);
        Marshaller mar= context.createMarshaller();
        mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        mar.marshal(transaction, outputStream);
    }

    public Transaction fromXML(String fileName) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(Transaction.class);
        return (Transaction) context.createUnmarshaller()
                .unmarshal(new FileReader(this.path + fileName));
    }

    public Transaction fromXML(InputStream inputStream) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Transaction.class);
        return (Transaction) context.createUnmarshaller()
                .unmarshal(inputStream);
    }

}
