package edu.pe.cibertec.stepdefinitions;

import edu.pe.cibertec.screenplay.tasks.IniciarSesionComo;
import edu.pe.cibertec.screenplay.ui.LoginPage;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.questions.Text;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.containsString;

public class LoginStepDefinitions {

    @Given("the user navigates to the login page")
    public void navigateToLoginPage() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("user").attemptsTo(
                Open.url("https://naveenautomationlabs.com/opencart/index.php?route=account/login")
        );
    }

    @When("the user enters email {string} and password {string}")
    public void enterCredentials(String email, String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                new IniciarSesionComo(email, password)
        );
    }

    @And("clicks on the login button")
    public void clickLogin() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(LoginPage.LOGIN_BUTTON)
        );
    }

    @Then("the user should see the name {string} in the page header")
    public void verifyName(String name) {
        OnStage.theActorInTheSpotlight().should(
                seeThat(Text.of(LoginPage.ACCOUNT_NAME), containsString(name))
        );
    }


}