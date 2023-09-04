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
    public void testViewUserProfile() {
        String existingUsername = "username";
        shoppingSystem.viewUserProfile(existingUsername);
        String nonExistingUsername = "nonexistentuser";
        shoppingSystem.viewUserProfile(nonExistingUsername);
    }
    
    @Test
    public void testUpdatePassword() {
        String existingUsername = "username";
        String newPassword = "newpassword";
        shoppingSystem.updatePassword(existingUsername, newPassword);
        boolean loginResult = shoppingSystem.login(existingUsername, newPassword);
        Assert.assertTrue(loginResult, "Password update should be successful.");
    }

    @Test
    public void testListAllProducts() {
        shoppingSystem.listAllProducts();
    }

    @Test
    public void testSearchProduct() {
        String searchKeyword = "Product 1";
        shoppingSystem.searchProduct(searchKeyword);
        String nonExistingKeyword = "Non-existent Product";
        shoppingSystem.searchProduct(nonExistingKeyword);
    }

    @Test
    public void testAddToCart() {
        String validProductTitle = "Product 2";
        shoppingSystem.addToCart(validProductTitle);
        String invalidProductTitle = "Invalid Product";
        shoppingSystem.addToCart(invalidProductTitle);
    }
    
    @Test
    public void testViewCartEmpty() {
        shoppingSystem.viewCart();
        String productTitle = "Product 1";
        shoppingSystem.addToCart(productTitle);
        shoppingSystem.viewCart();
    }
    @Test
    public void testVerifyProductTitle() {
        String existingProductTitle = "Product 1";
        boolean result = shoppingSystem.verifyProductTitle(existingProductTitle);
        Assert.assertTrue(result, "Product title should exist");
        String nonExistingProductTitle = "Non-existent Product";
        result = shoppingSystem.verifyProductTitle(nonExistingProductTitle);
        Assert.assertFalse(result, "Product title should not exist");
    }


    @Test
    public void testMakePayment() {
        String productTitle = "Product 3";
        shoppingSystem.addToCart(productTitle);
        shoppingSystem.makePayment();
        shoppingSystem.makePayment();
    }

}

