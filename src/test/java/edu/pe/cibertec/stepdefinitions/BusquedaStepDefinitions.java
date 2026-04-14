package edu.pe.cibertec.stepdefinitions;

import edu.pe.cibertec.screenplay.questions.ResultadosDeBusqueda;
import edu.pe.cibertec.screenplay.tasks.BuscarProducto;
import edu.pe.cibertec.screenplay.ui.BusquedaPage;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.Text;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.*;

public class BusquedaStepDefinitions {

    @Given("the user is on the OpenCart home page")
    public void navigateToHomePage() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("user").attemptsTo(
                Open.url("https://naveenautomationlabs.com/opencart")
        );
    }

    @When("the user searches for the product {string}")
    public void searchProduct(String product) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                new BuscarProducto(product)
        );
    }

    @Then("the user should see at least one result with the name {string}")
    public void verifyResults(String productName) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(ResultadosDeBusqueda.visibles(), hasItem(containsString(productName)))
        );
    }


}