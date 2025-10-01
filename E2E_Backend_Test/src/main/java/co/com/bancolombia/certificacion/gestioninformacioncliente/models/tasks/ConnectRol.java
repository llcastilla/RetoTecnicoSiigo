package co.com.bancolombia.certificacion.gestioninformacioncliente.models.tasks;

import co.com.bancolombia.certificacion.gestioninformacioncliente.models.utils.Constants;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;


public class ConnectRol implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {


        actor.attemptsTo(
                Get.resource(Constants.EMPTY)
                        .with(requestSpecification -> requestSpecification
                                .header(Constants.AUTHORIZATION, "Bearer " + Constants.TOKEN)
                                .relaxedHTTPSValidation()
                                .log().all()
                        )
        );
    }

    public static ConnectRol alServicio(){
      return Instrumented.instanceOf(ConnectRol.class).withProperties();
    }
}
