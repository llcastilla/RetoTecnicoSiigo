package co.com.siigo.certificacion.stepdefinitions;

import co.com.siigo.certificacion.models.tasks.ConnectExistClientApi;
import co.com.siigo.certificacion.models.tasks.ConnectUser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;

import static co.com.siigo.certificacion.models.utils.Constants.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.*;

public class ConsultarProductoStepDefinitions {
    Actor actor = Actor.named("tester");

    @Given("que un cliente autenticado desea obtener un listado de los productos")
    public void queUnClienteAutenticadoDeseaObtenerUnListadoDeLosProductos() {
        actor.attemptsTo(ConnectExistClientApi.alServicio(ENDPOINT_PRODUCTO_GET));
    }

    @When("se realiza una solicitud GET al endpoint de los productos")
    public void seRealizaUnaSolicitudGETAlEndpointDeLosProductos() {
        actor.attemptsTo(ConnectUser.alServicio());
    }

    @Then("el servicio responde con el código de estado exitoso y muestra datos del producto")
    public void elServicioRespondeConElCódigoDeEstadoExitosoYMuestraDatosDelProducto() {
        actor.should(
                seeThatResponse("El servicio debe responder con 200 y un producto válido",
                        response -> response
                                .statusCode(ESTADO_SERVICIO_OK)
                                .body("[0].id", notNullValue())
                                .body("[0].title", not(isEmptyOrNullString()))
                                .body("[0].price", greaterThan(0f))
                                .body("[0].description", not(isEmptyOrNullString()))
                                .body("[0].category", not(isEmptyOrNullString()))
                                .body("[0].image", not(isEmptyOrNullString()))
                                .body("[0].rating.rate", greaterThan(0f))
                                .body("[0].rating.count", greaterThanOrEqualTo(0))
                )
        );
    }
}
