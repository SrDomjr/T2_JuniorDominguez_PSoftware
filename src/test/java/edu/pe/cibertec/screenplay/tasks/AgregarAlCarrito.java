package edu.pe.cibertec.screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import edu.pe.cibertec.screenplay.ui.BusquedaPage;
import edu.pe.cibertec.screenplay.ui.CarritoPage;





public class AgregarAlCarrito implements Task {
    private final String producto;

    public AgregarAlCarrito(String producto) {
        this.producto = producto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(producto).into(BusquedaPage.SEARCH_INPUT),
                Click.on(BusquedaPage.SEARCH_BUTTON),
                Click.on(CarritoPage.ADD_TO_CART_BUTTON)
        );
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
    }


}