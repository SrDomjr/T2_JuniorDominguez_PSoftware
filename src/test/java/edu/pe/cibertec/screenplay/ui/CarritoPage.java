package edu.pe.cibertec.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CarritoPage {
    public static final Target CART_BUTTON = Target.the("cart button").located(By.id("cart-total"));
    public static final Target CART_ITEMS = Target.the("cart items").located(By.cssSelector("#cart-total"));

    public static final Target ADD_TO_CART_BUTTON = Target.the("add to cart")
            .located(By.cssSelector("div.button-group button:first-child"));

    public static final Target PRODUCT_IN_CART = Target.the("product in cart")
            .located(By.cssSelector("#content .table td:nth-child(2) a"));
}