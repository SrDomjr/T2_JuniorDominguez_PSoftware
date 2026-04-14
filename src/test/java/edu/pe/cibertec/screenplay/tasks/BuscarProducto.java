package edu.pe.cibertec.screenplay.tasks;

import edu.pe.cibertec.screenplay.ui.BusquedaPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

public class BuscarProducto implements Task {
    private final String producto;

    public BuscarProducto(String producto) {
        this.producto = producto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(producto).into(BusquedaPage.SEARCH_INPUT),
                Click.on(BusquedaPage.SEARCH_BUTTON)
        );
    }
}