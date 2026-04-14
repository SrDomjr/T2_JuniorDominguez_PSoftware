package edu.pe.cibertec.stepdefinitions;

import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.questions.Text;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.containsString;

public class CommonStepDefinitions {

    @Then("the user should see the message {string}")
    public void verifyMessage(String message) {
        Target msg = Target.the("page message")
                .located(By.xpath(
                        "//*[contains(@class,'alert') or @id='content'][contains(.,'"
                                + message.substring(0, Math.min(message.length(), 10)) + "')]"
                ));
        OnStage.theActorInTheSpotlight().should(
                seeThat(Text.of(msg), containsString(message))
        );
    }
}