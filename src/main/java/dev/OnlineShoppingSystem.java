package dev;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OnlineShoppingSystem {

    class Product {
        private String title;
        private double price;

        public Product(String title, double price) {
            this.title = title;
            this.price = price;
        }

        public String getTitle() {
            return title;
        }

        public double getPrice() {
            return price;
        }
    }

    private Map<String, String> userDatabase;
    private List<Product> products;
    private List<Product> shoppingCart;
    private double totalAmount;

    public OnlineShoppingSystem() {
        userDatabase = new HashMap<>();
        userDatabase.put("username", "password");

        products = new ArrayList<>();
        products.add(new Product("Product 1", 10.99));
        products.add(new Product("Product 2", 25.49));
        products.add(new Product("Product 3", 7.99));

        shoppingCart = new ArrayList<>();
        totalAmount = 0.0;
    }

    public boolean login(String username, String password) {
        String storedPassword = userDatabase.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }

    public void searchProduct(String keyword) {
        System.out.println("Search results for: " + keyword);
        for (Product product : products) {
            if (product.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(product.getTitle() + " - $" + product.getPrice());
            }
        }
    }

    public void addToCart(String productTitle) {
        for (Product product : products) {
            if (product.getTitle().equals(productTitle)) {
                shoppingCart.add(product);
                totalAmount += product.getPrice();
                System.out.println(productTitle + " added to cart.");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public void makePayment() {
        if (shoppingCart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        System.out.println("Total amount: $" + totalAmount);
        System.out.println("Enter payment details...");
        System.out.println("Payment successful!");
        shoppingCart.clear();
        totalAmount = 0.0;
    }

    public boolean verifyProductTitle(String productTitle) {
        for (Product product : products) {
            if (product.getTitle().equals(productTitle)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        OnlineShoppingSystem shoppingSystem = new OnlineShoppingSystem();
        String username = "username";
        String password = "password";

        if (shoppingSystem.login(username, password)) {
            System.out.println("Login successful!");
            String searchKeyword = "Product";
            shoppingSystem.searchProduct(searchKeyword);

            String productTitleToAdd = "Product 2";
            if (shoppingSystem.verifyProductTitle(productTitleToAdd)) {
                shoppingSystem.addToCart(productTitleToAdd);
            } else {
                System.out.println("Product not found.");
            }

            shoppingSystem.makePayment();
        } else {
            System.out.println("Login failed. Invalid username or password.");
        }
    }
}
