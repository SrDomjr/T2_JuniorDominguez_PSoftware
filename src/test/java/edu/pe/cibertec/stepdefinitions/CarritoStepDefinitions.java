package edu.pe.cibertec.stepdefinitions;

import edu.pe.cibertec.screenplay.questions.ContadorDelCarrito;
import edu.pe.cibertec.screenplay.tasks.AgregarAlCarrito;
import edu.pe.cibertec.screenplay.ui.CarritoPage;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actors.OnStage;

import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.Text;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.containsString;

public class CarritoStepDefinitions {

    @When("the user adds the product {string} to the cart")
    public void addProductToCart(String product) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                new AgregarAlCarrito(product)
        );
    }

    @Then("the cart should show {string}")
    public void verifyCartCount(String expected) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ContadorDelCarrito.actual(), containsString(expected))
        );
    }

    @And("navigates to the cart")
    public void navigateToCart() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Open.url("https://naveenautomationlabs.com/opencart/index.php?route=checkout/cart")
        );
    }

    @Then("the user should see the product {string} in the cart list")
    public void verifyProductInCart(String product) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(Text.of(CarritoPage.PRODUCT_IN_CART), containsString(product))
        );
    }
}