package ui;

//UI can only import Shop
import domain.Shop;

import javax.swing.*;

public class UI {
	private final Shop shop;
	public UI(Shop shop) {
		this.shop = shop;
		showMenu();
	}

	public void showMenu() {
		String menu = """
				1. Add product
				2. Show product
				3. Show rental price
				4. All products
				5. Manage product

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
					case "5" -> manageProduct();
					default -> menu = "Invalid option!\n" + menu;
				}
			}
		}
	}

	private boolean productExists(String idString) {
		try {
			int id = Integer.parseInt(idString);
			shop.getProductByID(id); //Test if product exists
			return true;
		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(null, "Invalid ID!");
			return false;
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			return false;
		}
	}

	private String getID() {
		return JOptionPane.showInputDialog("Enter the id:");
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

	public void showAllProducts() {
		String s = shop.getProductsInOrder();
		JOptionPane.showMessageDialog(null, s);
	}

	public void showProduct() {
		String idString = getID();
		if (productExists(idString)) {
			int id = Integer.parseInt(idString);
			JOptionPane.showMessageDialog(null, shop.getProductByID(id));
		}
	}

	public void showPrice() {
		String idString = getID();
		if (productExists(idString)) {
			int id = Integer.parseInt(idString);
			JOptionPane.showMessageDialog(null, shop.getProductByID(id));
			String days = JOptionPane.showInputDialog("Enter the number of days:");
			try {
				JOptionPane.showMessageDialog(null, shop.getPrice(Integer.parseInt(days), id));
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Invalid number of days!");
			}
		}
	}

	private void manageProduct() {
		String idString = getID();
		if (productExists(idString)) {
			int id = Integer.parseInt(idString);
			String choice = JOptionPane.showInputDialog(shop.getProductByID(id) + """
				
				
				Options:
				1. Rent
				2. Set available
				3. Set damaged
				4. Fix damage
				5. Remove product""");

			try {
				switch (choice) {
					case "1" -> setRented(id);
					case "2" -> setAvailable(id);
					case "3" -> setDamaged(id);
					case "4" -> fixDamage(id);
					case "5" -> remove(id);
				}
			} catch (IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}
	}

	private void remove(int id) {
		try {
			shop.remove(id);
			JOptionPane.showMessageDialog(null, "Product successfully removed.");
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	private void fixDamage(int id) {
		try {
			shop.fixDamage(id);
			JOptionPane.showMessageDialog(null, "Product successfully repaired.");
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	private void setDamaged(int id) {
		try {
			shop.setDamaged(id);
			JOptionPane.showMessageDialog(null, "Product successfully set as damaged.");
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	private void setAvailable(int id) {
		try {
			shop.setAvailable(id);
			JOptionPane.showMessageDialog(null, "Product successfully set as available.");
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

	private void setRented(int id) {
		try {
			shop.setRented(id);
			JOptionPane.showMessageDialog(null, "Product successfully set as not available.");
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

}
