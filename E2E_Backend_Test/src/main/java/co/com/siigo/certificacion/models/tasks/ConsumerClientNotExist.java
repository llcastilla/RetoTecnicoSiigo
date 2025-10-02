package co.com.siigo.certificacion.models.tasks;

import co.com.siigo.certificacion.models.utils.Constants;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class ConsumerClientNotExist implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(Constants.EMPTY)
                .with(requestSpecification -> requestSpecification
                .header(Constants.AUTHORIZATION,"Bearer "+ Constants.TOKEN)
                        .formParam(Constants.GRANT_TYPE, Constants.GRANT_TYPE_VALUE)
                        .relaxedHTTPSValidation()
                )
        );

    }

    public static ConsumerClientNotExist elServicioNoExiste(){
        return Instrumented.instanceOf(ConsumerClientNotExist.class).withProperties();
    }
}
