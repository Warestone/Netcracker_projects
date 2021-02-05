package com.warestone_company.NCprojects.java.horstmann.inheritanceAndReflection;

import java.util.InputMismatchException;
import java.util.Objects;

        /*6. Suppose that in Section 4.2.2, “The equals Method” (page 148), the
        Item.equals method uses an instanceof test. Implement DiscountedItem.equals so
        that it compares only the superclass if otherObject is an Item, but also includes the discount if it is a DiscountedItem. Show that this method preserves
        symmetry but fails to be transitive—that is, find a combination of items
        and discounted items so that x.equals(y) and y.equals(z), but not x.equals(z).
        */

public class Item {
    private String description;
    private double price;

    public Item(String description, double price) {
        if (description==null || price<0) throw new InputMismatchException("Description don't be null & price must be above zero");
        this.description = description;
        this.price = price;
    }

    public String getDescription() { return description; }
    public double getPrice() { return price; }

    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        Item other = (Item) otherObject;
        return Objects.equals(description, other.description) && price == other.price;
    }
}
