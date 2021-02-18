package main;

import status.Status;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    private String name;
    private String lastName;
    private String email;
    private List<String> phones;
    private List<Status> status;


    public User(String name, String lastName, String email, List<String> phones, List<Status> status) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.phones = phones;
        this.status = status;
    }

    public void setStatus(List<Status> status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return " : " +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phones=" + phones +
                ", status=" + status +
                '.';
    }
}
