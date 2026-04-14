package edu.pe.cibertec.screenplay.tasks;

import edu.pe.cibertec.screenplay.ui.RegistroPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class RegistrarseComo implements Task {
    private final String firstName, lastName, email, phone, password;

    public RegistrarseComo(String firstName, String lastName, String email, String phone, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(firstName).into(RegistroPage.FIRST_NAME),
                Enter.theValue(lastName).into(RegistroPage.LAST_NAME),
                Enter.theValue(email).into(RegistroPage.EMAIL),
                Enter.theValue(phone).into(RegistroPage.PHONE),
                Enter.theValue(password).into(RegistroPage.PASSWORD),
                Enter.theValue(password).into(RegistroPage.CONFIRM_PASSWORD)
        );
    }
}