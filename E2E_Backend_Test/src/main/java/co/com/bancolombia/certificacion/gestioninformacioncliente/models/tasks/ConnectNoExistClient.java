package co.com.bancolombia.certificacion.gestioninformacioncliente.models.tasks;

import co.com.bancolombia.certificacion.gestioninformacioncliente.models.utils.Constants;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class ConnectNoExistClient implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();
        actor.whoCan(
                CallAnApi.at(Constants.ENDPOINT_CONSULTARCLIENTES_NOT_EXIST)
        );
    }
    public static ConnectNoExistClient alServicio (){
        return Instrumented.instanceOf(ConnectNoExistClient.class).withProperties();
    }
}
