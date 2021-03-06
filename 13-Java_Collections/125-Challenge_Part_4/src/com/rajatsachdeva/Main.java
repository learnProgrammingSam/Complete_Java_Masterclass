package com.rajatsachdeva;

import java.util.Map;

public class Main {

    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.0, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.50, 200);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.45, 7);
        stockList.addStock(temp);

        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.5, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 96.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);

        System.out.println(stockList);
        System.out.println();

        for (String s : stockList.Items().keySet()) {
            System.out.println(s);
        }

        Basket rajatsBasket = new Basket("Rajat");

        sellItem(rajatsBasket, "car", 1);
        System.out.println(rajatsBasket);

        sellItem(rajatsBasket, "car", 1);
        System.out.println(rajatsBasket);

        if (sellItem(rajatsBasket, "car", 1) != 1) {
            System.out.println("There are no more cars to sell");
        }
        sellItem(rajatsBasket, "item that does not exists", 1);
//        System.out.println(rajatsBasket);

        sellItem(rajatsBasket, "juice", 4);
        sellItem(rajatsBasket, "cup", 12);
        sellItem(rajatsBasket, "bread", 1);
//        System.out.println(rajatsBasket);

//        System.out.println(stockList);

        Basket basket = new Basket("customer");
        sellItem(basket, "cup", 100);
        sellItem(basket, "juice", 5);
        removeItem(basket, "cup", 1);
        System.out.println(basket);

        removeItem(rajatsBasket, "car", 1);
        removeItem(rajatsBasket, "cup", 9);
        removeItem(rajatsBasket, "car", 1);
        System.out.println("cars removed : " + removeItem(rajatsBasket, "car", 1)); // should not remove any
        System.out.println(rajatsBasket);

        // remove remaining items from rajatsBasket
        removeItem(rajatsBasket, "bread", 1);
        removeItem(rajatsBasket, "cup", 3);
        removeItem(rajatsBasket, "juice", 4);
        removeItem(rajatsBasket, "cup", 3);
        System.out.println(rajatsBasket);

        System.out.println("\nDisplay Stock List before and after checkout");
        System.out.println(basket);
        System.out.println(stockList);
        checkOut(basket);
        System.out.println(basket);
        System.out.println(stockList);

        // Following generates an exception as we are adding element in an Unmodifiable Map
//        temp = new StockItem("pen", 1.12);
//        stockList.Items().put(temp.getName(), temp);
//        stockList.Items().get("car").adjustStock(2000); // adjusting the quantity of a stock that doesn't exist
        StockItem car = stockList.Items().get("car");
        if (car != null) {
            car.adjustStock(2000);
        }

        if (car != null) {
            car.adjustStock(-1000);
        }

        System.out.println(stockList);

//        for (Map.Entry<String, Double> price : stockList.PriceList().entrySet()) {
//            System.out.println(price.getKey() + " costs " + price.getValue());
//        }

        checkOut(rajatsBasket);
        System.out.println(rajatsBasket);
    }

    public static int sellItem(Basket basket, String item, int quantity) {
        // retrieve the item from stock list
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }

        if (stockList.reserveStock(item, quantity) != 0) {
            return basket.addToBasket(stockItem, quantity);
        }
        return 0; // didn't have sufficient quantity to sell
    }

    public static int removeItem(Basket basket, String item, int quantity) {
        // retrieve the item from stock list
        StockItem stockItem = stockList.get(item);
        if (stockItem == null) {
            System.out.println("We don't sell " + item);
            return 0;
        }

        if (basket.removeFromBasket(stockItem, quantity) == quantity) {
            return stockList.unreserveStock(item, quantity);
        }
        return 0; // didn't have sufficient quantity to sell
    }

    public static void checkOut(Basket basket) {
        for(Map.Entry<StockItem, Integer> item : basket.Items().entrySet()) {
            stockList.sellStock(item.getKey().getName(), item.getValue());
        }
        basket.clearBasket();
    }
}
