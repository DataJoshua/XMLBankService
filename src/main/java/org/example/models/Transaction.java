package org.example.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Transaction {
    private User user;
    private String bankName;
    private int summ;
    private String currency;

    public Transaction(User user, Bank bank, int summ, String currency) {
        this.user = user;
        this.bankName = bank.getName();
        this.summ = summ;
        this.currency = currency;
    }


    public Transaction(){

    }


    public User getUser() {
        return user;
    }

    @XmlElement(name="user")
    public void setUser(User user) {
        this.user = user;
    }

    public String getBankName() {
        return bankName;
    }

    @XmlElement
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public int getSumm() {
        return summ;
    }

    @XmlElement
    public void setSumm(int summ) {
        this.summ = summ;
    }

    public String getCurrency() {
        return currency;
    }

    @XmlElement
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "user=" + user +
                ", bankName='" + bankName + '\'' +
                ", summ=" + summ +
                ", currency='" + currency + '\'' +
                '}';
    }
}
