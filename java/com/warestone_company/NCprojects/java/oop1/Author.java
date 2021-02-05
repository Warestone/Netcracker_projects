package com.warestone_company.NCprojects.java.oop1;

import java.util.Objects;

public class Author {

    private String name, email;
    private char gender;

    public Author(String name, String email, char gender){  // values may be null or "", if author (or/and email) of book is unknown
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public char getGender() { return gender; }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return this.gender == author.gender && this.name.equals(author.name) && this.email.equals(author.email);
    }

    @Override
    public int hashCode() {
        final int hash = 5;
        final int multiplier = 2;
        return (hash*multiplier + Objects.hash(name,email,gender));
    }

    @Override
    public String toString() {
        return "Author{" + "name='" + name + '\'' + ", email='" + email + '\'' + ", gender=" + gender + '}';
    }
}
