package co.com.siigo.certificacion.stepdefinitions;



import co.com.siigo.certificacion.models.tasks.ConnectExistClientApi;
import co.com.siigo.certificacion.models.tasks.ConsumerPatch;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import static org.hamcrest.Matchers.*;

import static co.com.siigo.certificacion.models.utils.Constants.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ModificarProductoStepDefinitions {
    Actor actor = Actor.named("tester");

    @Given("que el servicio  de productos está activo")
    public void queElServicioDeProductosEstáActivo() {
        actor.attemptsTo(ConnectExistClientApi.alServicio(ENDPOINT_PRODUCTO_PATCH));

    }


    @When("el cliente envía una solicitud patch al endpoint de productos con todos los datos requeridos y un token válido")
    public void elClienteEnvíaUnaSolicitudPatchAlEndpointDeProductosConTodosLosDatosRequeridosYUnTokenVálido() {
        actor.attemptsTo(ConsumerPatch.elServicio(QUERYPRODUCTO));

    }

    @Then("el servicio responde con el código de estado HTTP")
    public void elServicioRespondeConElCódigoDeEstadoHTTPCreated() {
        actor.should(
                seeThatResponse("El servicio debe responder con código exitoso y devolver los datos del producto",
                        response -> response
                                .statusCode(ESTADO_SERVICIO_OK) // normalmente sería 201 Created para creación
                                .body("id", notNullValue())
                                .body("id", equalTo(1))
                                .body("title", not(isEmptyOrNullString()))
                                .body("title", equalTo("New Product"))
                                .body("price", greaterThan(0f))
                                .body("price", equalTo(29.99f))
                )
        );
    }


}
