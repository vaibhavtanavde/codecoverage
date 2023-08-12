package test;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import dev.OnlineShoppingSystem;

public class OnlineShoppingSystemTest {

	public OnlineShoppingSystem shoppingSystem;

    @BeforeClass
    public void setUp() {
        shoppingSystem = new OnlineShoppingSystem();
    }

    @Test
    public void testLoginSuccess() {
        boolean result = shoppingSystem.login("username", "password");
        Assert.assertTrue(result, "Login should succeed");
    }

    @Test
    public void testLoginFailure() {
        boolean result = shoppingSystem.login("invalidUsername", "invalidPassword");
        Assert.assertFalse(result, "Login should fail with invalid credentials");
    }

    @Test
    public void testSearchProduct() {
        // Test search for an existing product
        String searchKeyword = "Product 1";
        shoppingSystem.searchProduct(searchKeyword);

        // Test search for a non-existing product
        String nonExistingKeyword = "Non-existent Product";
        shoppingSystem.searchProduct(nonExistingKeyword);
    }

    @Test
    public void testAddToCart() {
        // Test adding a valid product to the cart
        String validProductTitle = "Product 2";
        shoppingSystem.addToCart(validProductTitle);

        // Test adding an invalid product to the cart
        String invalidProductTitle = "Invalid Product";
        shoppingSystem.addToCart(invalidProductTitle);
    }

    @Test
    public void testMakePayment() {
        // Test making a payment with items in the cart
        String productTitle = "Product 3";
        shoppingSystem.addToCart(productTitle);
        shoppingSystem.makePayment();

        // Test making a payment with an empty cart
        shoppingSystem.makePayment();
    }

    @Test
    public void testVerifyProductTitle() {
        // Test verifying an existing product title
        String existingProductTitle = "Product 1";
        boolean result = shoppingSystem.verifyProductTitle(existingProductTitle);
        Assert.assertTrue(result, "Product title should exist");

        // Test verifying a non-existing product title
        String nonExistingProductTitle = "Non-existent Product";
        result = shoppingSystem.verifyProductTitle(nonExistingProductTitle);
        Assert.assertFalse(result, "Product title should not exist");
    }
}

