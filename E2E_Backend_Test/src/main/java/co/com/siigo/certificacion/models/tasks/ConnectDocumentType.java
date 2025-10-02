package co.com.siigo.certificacion.models.tasks;

import co.com.siigo.certificacion.models.utils.Constants;
import co.com.siigo.certificacion.models.utils.GetProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;



public class ConnectDocumentType implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        String url = GetProperties.get("url.endpoint");
        SerenityRest.reset();

        actor.whoCan(
                CallAnApi.at(url)
        );

        actor.attemptsTo(
                Get.resource(Constants.EMPTY)
                        .with(requestSpecification -> requestSpecification
                                .header(Constants.AUTHORIZATION,"Bearer "+ Constants.TOKEN)
                                .formParam(Constants.GRANT_TYPE, Constants.GRANT_TYPE_VALUE)
                                .relaxedHTTPSValidation()
                        )
        );
    }

    public static ConnectDocumentType alServicio(){
      return Instrumented.instanceOf(ConnectDocumentType.class).withProperties();
    }
}
