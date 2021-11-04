package db;

import domain.CD;
import domain.Game;
import domain.Movie;
import domain.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDB {
    private final List<Product> products;

    public ProductDB() {
        products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(String type, String title) throws IllegalArgumentException {
        if (type == null || type.isBlank()) throw new IllegalArgumentException("Invalid type!");
        int newID = products.size()+1;
        switch (type) {
            case "M" -> products.add(new Movie(newID, title));
            case "G" -> products.add(new Game(newID, title));
            case "C" -> products.add(new CD(newID, title));
            default -> throw new IllegalArgumentException("Invalid type!");
        }
    }

    public void removeProduct(int id) {
        products.removeIf(p -> p.getId() == id);
    }

    public Product getProductByID(int id) {
        for (Product p : products) {
            if (p.getId() == id) return p;
        } return null;
    }
}
