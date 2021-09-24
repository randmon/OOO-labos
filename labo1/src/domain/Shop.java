package domain;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private final List<Product> products;

    public Shop() {
        products = new ArrayList<>();
    }

    public void addProduct(String type, String title) {
        if (type == null || type.isBlank()) throw new IllegalArgumentException("Invalid type!");
        int newID = products.size()+1;
        switch (type) {
            case "M" -> products.add(new Movie(newID, title));
            case "G" -> products.add(new Game(newID, title));
            case "C" -> products.add(new CD(newID, title));
            default -> throw new IllegalArgumentException("Invalid type!");
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductByID(int id) {
        for (Product p : products) {
            if (p.getId() == id) return p;
        } return null;
    }
}
