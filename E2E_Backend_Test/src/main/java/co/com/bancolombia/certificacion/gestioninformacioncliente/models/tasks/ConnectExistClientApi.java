package co.com.bancolombia.certificacion.gestioninformacioncliente.models.tasks;


import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class ConnectExistClientApi implements Task {

    String endPoint;
    public ConnectExistClientApi(String endPoint){
        this.endPoint = endPoint;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();
        actor.whoCan(
                CallAnApi.at(endPoint)
        );

        System.out.println("endpoint:" +endPoint);
    }

    public static ConnectExistClientApi alServicio(String endPoint){
        return Instrumented.instanceOf(ConnectExistClientApi.class).withProperties(endPoint);
    }
}
