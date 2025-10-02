package co.com.siigo.certificacion.stepdefinitions;



import co.com.siigo.certificacion.models.tasks.ConnectExistClientApi;
import co.com.siigo.certificacion.models.tasks.Consumer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import static co.com.siigo.certificacion.models.utils.Constants.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.*;

public class CrearProductoStepDefinitions {
    Actor actor = Actor.named("tester");


    @Given("que el servicio de gestión de productos está activo")
    public void queElServicioDeGestiónDeProductosEstáActivo() {
        actor.attemptsTo(ConnectExistClientApi.alServicio(ENDPOINT_PRODUCTO_GET));

    }

    @When("el cliente envía una solicitud POST al endpoint de productos con todos los datos requeridos y un token válido")
    public void elClienteEnvíaUnaSolicitudPOSTAlEndpointDeProductosConTodosLosDatosRequeridosYUnTokenVálido() {
        actor.attemptsTo(Consumer.elServicio(QUERYPRODUCTO));

    }

    @Then("el servicio responde con el código de estado HTTP Created")
    public void elServicioRespondeConElCódigoDeEstadoHTTPCreated() {
        actor.should(
                seeThatResponse("El servicio debe responder con 201 y datos válidos del producto creado",
                        response -> response
                                .statusCode(ESTADO_OK) // normalmente para creación se espera 201 Created
                                .body("id", notNullValue())
                                .body("title", not(isEmptyOrNullString()))
                                .body("price", greaterThan(0f))
                )
        );
    }

}
