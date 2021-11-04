package ui;

import domain.Shop;

public class App {

    public static void main(String[] args) {
        Shop shop = new Shop();
        shop.loadFile("products.txt");
        new UI(shop);
        shop.saveToFile("products.txt");
    }
}
