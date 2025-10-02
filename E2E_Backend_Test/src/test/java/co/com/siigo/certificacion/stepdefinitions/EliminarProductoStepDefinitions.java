package co.com.siigo.certificacion.stepdefinitions;

import co.com.siigo.certificacion.models.tasks.ConnectExistClientApi;
import co.com.siigo.certificacion.models.tasks.DeleteClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import static org.hamcrest.Matchers.*;

import static co.com.siigo.certificacion.models.utils.Constants.*;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class EliminarProductoStepDefinitions {
    Actor actor = Actor.named("tester");


    @Given("que un cliente autenticado desea eliminar un producto")
    public void queUnClienteAutenticadoDeseaEliminarUnProducto() {
        actor.attemptsTo(ConnectExistClientApi.alServicio(ENDPOINT_PRODUCTO_DEL));

    } @When("se realiza una solicitud DELETE al endpoint de producto")
    public void seRealizaUnaSolicitudDELETEAlEndpointDeProducto() {
        actor.attemptsTo(DeleteClass.alServicio());

    }
    @Then("el servicio responde con el código de estado OK")
    public void elServicioRespondeConElCódigoDeEstadoOK() {
        actor.should(
                seeThatResponse("El servicio debe responder con 200 OK y devolver los datos completos del producto",
                        response -> response
                                .statusCode(ESTADO_SERVICIO_OK)
                                .body("id", notNullValue())
                                .body("title", not(isEmptyOrNullString()))
                                .body("price", greaterThan(0f))
                                .body("description", not(isEmptyOrNullString()))
                                .body("category", not(isEmptyOrNullString()))
                                .body("image", not(isEmptyOrNullString()))
                                .body("rating.rate", greaterThan(0f))
                                .body("rating.count", greaterThanOrEqualTo(0))
                )
        );
    }



}
