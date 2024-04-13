package org.example;

public abstract class Staff {
    private String FirstName;
    private String LastName;
    private String Tckn;

    public void getSalary() {

    }

    public void eatMeal() {

    }

    public void breathe() {

    }

    // Getters & Setters

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getTckn() {
        return Tckn;
    }

    public void setTckn(String tckn) {
        Tckn = tckn;
    }
}
