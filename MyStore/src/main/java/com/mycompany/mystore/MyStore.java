/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mystore;
import java.util.*; 

/**
 *
 * @author TTang2026
 */
public class MyStore {
    // Maximum budget constant
    private static final double MAX_BUDGET = 250.00;

    public static void main(String[] args) {
        // Create items and store in a map for easy lookup
        HashMap<String, Item> items = new HashMap<>();
        items.put("T Shirt", new Item("T Shirt", 29.99));
        items.put("Shoes", new Item("Shoes", 125.99));
        items.put("Jeans", new Item("Jeans", 60.99));
        items.put("Jacket", new Item("Jacket", 250.00));
        items.put("Hat", new Item("Hat", 25.99));
        items.put("Shorts", new Item("Shorts", 75.99));
        items.put("Blouse", new Item("Blouse", 88.99));

        // Variables to keep track of the total cost and item count
        double totalSpent = 0.0;
        int itemCount = 0;

        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome! You have a budget of $" + MAX_BUDGET);

        while (true) {
            System.out.print("Enter the item you want to buy (or 'exit' to finish): ");
            String itemName = scan.nextLine();

            // Exit condition
            if (itemName.equalsIgnoreCase("exit")) {
                break;
            }

            // Check if the item exists in our store
            Item selectedItem = items.get(itemName);
            if (selectedItem != null) {
                double itemPrice = selectedItem.getDblPrice();

                // Check if adding this item would go over budget
                if (totalSpent + itemPrice > MAX_BUDGET) {
                    System.out.println("Warning: Adding this item would exceed your budget...");
                    System.out.println("Current total: $" + totalSpent + ", Item price: $" + itemPrice);
                    continue; // Skip adding this item
                }

                // Add item to the cart
                totalSpent += itemPrice;
                itemCount++;
                System.out.println("Added: " + selectedItem);
                System.out.println("Total items: " + itemCount + ", Total spent: $" + totalSpent);

            } else {
                System.out.println("Item not found. Please choose a valid item.");
            }
        }

        System.out.println("Thank you for shopping with us! You bought " + itemCount + " items for a total of $" + totalSpent);
    }
}

class Item {
    private String strName;
    private double dblPrice;

    public Item(String name, double price) {
        this.strName = name;
        this.dblPrice = price;
    }

    public String getStrName() {
        return strName;
    }

    public void setStrName(String name) {
        this.strName = name;
    }

    public double getDblPrice() {
        return dblPrice;
    }

    public void setDblPrice(double price) {
        this.dblPrice = price;
    }

    @Override
    public String toString() {
        return "Item: " + strName + ", Price: $" + dblPrice;
    }
}

