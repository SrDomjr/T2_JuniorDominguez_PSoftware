package edu.pe.cibertec.stepdefinitions;

import edu.pe.cibertec.screenplay.tasks.RegistrarseComo;
import edu.pe.cibertec.screenplay.ui.RegistroPage;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.questions.Text;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.containsString;

public class RegistroStepDefinitions {

    @Given("the user navigates to the register page")
    public void navigateToRegisterPage() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("user").attemptsTo(
                Open.url("https://naveenautomationlabs.com/opencart/index.php?route=account/register")
        );
    }

    @When("the user fills the form with first name {string}, last name {string}, email {string}, phone {string} and password {string}")
    public void fillForm(String firstName, String lastName, String email, String phone, String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                new RegistrarseComo(firstName, lastName, email, phone, password)
        );
    }

    @And("accepts the privacy policy")
    public void acceptPrivacyPolicy() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(RegistroPage.PRIVACY_POLICY)
        );
    }

    @And("clicks on continue")
    public void clickContinue() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                Click.on(RegistroPage.CONTINUE_BUTTON)
        );
    }


}