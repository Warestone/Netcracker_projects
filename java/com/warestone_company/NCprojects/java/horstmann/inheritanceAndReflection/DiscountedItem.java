package com.warestone_company.NCprojects.java.horstmann.inheritanceAndReflection;

import java.util.InputMismatchException;

        /*6. Suppose that in Section 4.2.2, “The equals Method” (page 148), the
        Item.equals method uses an instanceof test. Implement DiscountedItem.equals so
        that it compares only the superclass if otherObject is an Item, but also includes the discount if it is a DiscountedItem. Show that this method preserves
        symmetry but fails to be transitive—that is, find a combination of items
        and discounted items so that x.equals(y) and y.equals(z), but not x.equals(z).
        */

public class DiscountedItem extends Item{
    private double discount;

    public DiscountedItem(String description, double price, double discount) {
        super(description, price);
        if (discount<=0) throw new InputMismatchException("Discount must be above zero");
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof DiscountedItem){
            DiscountedItem that = (DiscountedItem) o;
            return Double.compare(that.discount, discount) == 0;
        }
        else if (super.equals(o)){
            Item that = (Item) o;
            return Double.compare(getPrice(),that.getPrice()) == 0 && that.getDescription().equals(getDescription());
        }
        return false;
    }
}
