package com.rajatsachdeva;

public class StockItem implements Comparable<StockItem>{
    private final String name;
    private double price;
    private int quantityStock = 0; // can be initialized later as well

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityStock = 0; // we don't need this twice but we do either way
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantityStock() {
        return quantityStock;
    }

    public void setPrice(double price) {
        if(price > 0.0) {
            this.price = price;
        }
    }

    public void adjustStock(int quantity) {
        int newQuantity = this.quantityStock + quantity;

        if(newQuantity > 0.0) {
            this.quantityStock = newQuantity;
        }
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItem.equals()");
        if(obj == this) {
            return true;
        }

        if(obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        String objName = ((StockItem) obj).getName();
        return this.getName().equals(objName);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 621;
    }

    @Override
    public int compareTo(StockItem o) {
        System.out.println("Entering StockItem.compareTo()");
        if (this == o) {
            return 0;
        }
    }
}
