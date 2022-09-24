package org.example.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
@XmlRootElement
public class Bank {

    private String name;
    private List<User> users;

    public Bank(){

    }


    public Bank(String name, List<User> users) {
        this.name = name;
        this.users = users;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }


    public List<User> getUsers() {
        return users;
    }
    @XmlElement
    @XmlElementWrapper(name="users")
    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", users=" + users +
                '}';
    }
}
