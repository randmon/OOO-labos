package ui;

import domain.Product;
import domain.Shop;
import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class UI {
	private final Shop shop = new Shop();
	private final String path = "products.txt";

	public static void main(String[] args) {
		new UI();
	}

	public UI() {
		loadFile();
		showMenu();
		saveToFile();
	}

	public void showMenu() {

		String menu = """
				1. Add product
				2. Show product
				3. Show rental price
				4. All products
				5. Set as rented

				0. Quit""";
		String  choice = "";
		while (!choice.equals("0")) {
			choice = JOptionPane.showInputDialog(menu);
			if (choice == null || choice.isBlank()) {
				break;
			} else {
				switch (choice) {
					case "1" -> addProduct();
					case "2" -> showProduct();
					case "3" -> showPrice();
					case "4" -> showAllProducts();
					case "5" -> setRented();
					default -> menu = "Invalid option!\n" + menu;
				}
			}
		}
	}

	public void addProduct() {
		String title = JOptionPane.showInputDialog("Enter the title:");
		String type = JOptionPane.showInputDialog("""
				Enter the type:
				C - CD
				G - Game
				M - Movie""");

		try {
			shop.addProduct(type, title);
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	public void showProduct() {
		String idString = JOptionPane.showInputDialog("Enter the id:");
		try {
			int id = Integer.parseInt(idString);
			Product p = shop.getProductByID(id);
			JOptionPane.showMessageDialog(null, Objects.requireNonNullElseGet(p, () -> "Product with ID (" + id + ") not found!"));
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Invalid ID!");
		}
	}

	public void showPrice() {
		String idString = JOptionPane.showInputDialog("Enter the id:");
		try {
			int id = Integer.parseInt(idString);
			Product p = shop.getProductByID(id);
			JOptionPane.showMessageDialog(null, Objects.requireNonNullElseGet(p, () -> "Product with ID (" + id + ") not found!"));
			if (p != null){
				String days = JOptionPane.showInputDialog("Enter the number of days:");
				try {
					JOptionPane.showMessageDialog(null, p.getPrice(Integer.parseInt(days)));
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Invalid number of days!");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Product with ID (" + id + ") not found!");
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Invalid ID!");
		}
	}

	public void showAllProducts() {
		List<Product> allProducts = shop.getProducts();
		allProducts.sort(Comparator.comparing(o -> o.getClass().getName()).reversed());
		StringBuilder s = new StringBuilder();
		for (Product p : allProducts) {
			s.append(p).append("\n\n");
		}
		JOptionPane.showMessageDialog(null, s);
	}

	private void setRented() {
		String idString = JOptionPane.showInputDialog("Enter the id:");
		try {
			int id = Integer.parseInt(idString);
			Product p = shop.getProductByID(id);
			if (p != null) {
				p.setAvailable(false);
				JOptionPane.showMessageDialog(null, "Product successfully set as not available.");
			} else {
				JOptionPane.showMessageDialog(null, "Product with ID (" + id + ") not found!");
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Invalid ID!");
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	private void saveToFile() {
		//Producten opslaan in een bestand
		try {
			FileWriter writer = new FileWriter(path);
			for (Product p : shop.getProducts()) {
				writer.write(p.toString() + "\n");
			}
			writer.close();
			System.out.println("Successfully wrote (" + shop.getProducts().size() + ") products to file.");
		} catch (IOException e) {
			System.out.println(">>> File error!!!");
			e.printStackTrace();
		}
	}

	private void loadFile() {
		File file = new File(path);
		try {
			Scanner scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				//Type
				String type = scanner.nextLine();
				type = type.substring(1, 2); //Only first letter of Type
				//ID
				String id = scanner.nextLine();
				//Title
				String title = scanner.nextLine();
				title = title.substring(7);
				//Available
				String av = scanner.nextLine();
				boolean available = av.equals("Available: true");

				//Try to make product
				try {
					shop.addProduct(type, title);
					if (!available) {
						Product p = shop.getProductByID(Integer.parseInt(id));
						p.setAvailable(false);
					}
				} catch (NumberFormatException nfe) {
					System.out.println("Invalid ID in file!!");
				}
			}
			scanner.close();
			System.out.println("Successfully loaded (" + shop.getProducts().size() + ") products from file.");
		} catch (FileNotFoundException fnfe ){
			System.out.println("File doesn't exist yet.");
		} catch (Exception e) {
			System.out.println("Error found while reading file!!");
		}
	}
}
