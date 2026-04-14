package edu.pe.cibertec.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage {
    public static final Target EMAIL = Target.the("email").located(By.id("input-email"));
    public static final Target PASSWORD = Target.the("password").located(By.id("input-password"));
    public static final Target LOGIN_BUTTON = Target.the("login button").located(By.cssSelector("input[value='Login']"));
    public static final Target WARNING_MESSAGE = Target.the("warning message").located(By.cssSelector(".alert-danger"));

    public static final Target ACCOUNT_NAME = Target.the("account name")
            .located(By.cssSelector("#top-links .dropdown-toggle"));

}