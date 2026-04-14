package edu.pe.cibertec.screenplay.questions;

import edu.pe.cibertec.screenplay.ui.CarritoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ContadorDelCarrito implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return Text.of(CarritoPage.CART_ITEMS).answeredBy(actor);
    }

    public static ContadorDelCarrito actual() {
        return new ContadorDelCarrito();
    }
}