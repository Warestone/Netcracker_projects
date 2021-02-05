package com.warestone_company.NCprojects.java.oop1;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Objects;

public class Book {

    private String name;
    private Author[] authors;
    private double price;
    private int qty;

    public Book(String name, Author[] authors, double price){
       setData(name,authors,price);
    }

    public Book(String name, Author[] authors, double price, int qty){
        setData(name,authors,price);
        setQty(qty);
    }

    private void setData(String name, Author[] authors, double price){
        if (name==null || authors==null) throw new InputMismatchException("Book name & authors must don't be null");
        if (name.equals("") || authors.length==0) throw new InputMismatchException("Book name & authors must don't be empty");
        setPrice(price);
        this.name = name;
        this.authors = authors;
    }

    public String getName(){
        return name;
    }

    public Author[] getAuthors(){
        return authors;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        if (price>0)this.price = price;
        else throw new InputMismatchException("Price of book must be above zero");
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        if(qty>0)this.qty = qty;
        else throw new InputMismatchException("Quantity of book must be above zero");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Double.compare(book.price, this.price) == 0 && this.qty == book.qty && this.name.equals(book.name) && Arrays.equals(this.authors, book.authors);
    }

    @Override
    public int hashCode() {
        final int hash = 6;
        final int multiplier = 3;
        return (hash * multiplier + Objects.hash(name, price) + Arrays.hashCode(authors) + qty);
    }

    @Override
    public String toString(){
        StringBuffer output = new StringBuffer();   // because i don't know where it will be used (in multithreaded-mode or single-mode)
        output.append("Book[name='").append(name).append("',authors={");
        if (authors!=null) {
            boolean firstAuthor = true;
            for (Author author : authors) {
                if (firstAuthor) firstAuthor = false;
                else output.append(',');
                output.append(author.toString());
            }
        }
        output.append("},price=").append(price).append(",qty=").append(qty).append(']');
        return output.toString();
    }

    public String getAuthorsNames(){
        if (authors!=null)
        {
            StringBuffer output =  new StringBuffer();     // same cause
            boolean firstAuthor = true;
            for (Author author : authors)
            {
                if (firstAuthor) firstAuthor = false;
                else output.append(',');
                output.append(author.getName());
            }
            return output.toString();
        }
        else return null;
    }
}
