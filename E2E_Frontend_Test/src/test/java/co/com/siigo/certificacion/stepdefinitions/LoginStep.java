package co.com.siigo.certificacion.stepdefinitions;

import co.com.siigo.certificacion.exeptions.AccountCreationFailure;
import co.com.siigo.certificacion.models.Customer;
import co.com.siigo.certificacion.questions.SuccessMessageLinkFormDigital;
import co.com.siigo.certificacion.tasks.*;
import co.com.siigo.certificacion.userinterfaces.login.MainPagePage;
import co.com.siigo.certificacion.utils.dataPruebas;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.webdriver.SerenityWebdriverManager;
import org.hamcrest.Matchers;

import static co.com.siigo.certificacion.utils.Constants.MESSAGESUCCESLINKFORMDIGITAL;
import static co.com.siigo.certificacion.utils.WordsToRemember.CUSTOMER_DATA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class LoginStep {

    @After
    public static void CloseDriver() {
        SerenityWebdriverManager.inThisTestThread().getCurrentDriver().quit();
    }

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        Actor actor = OnStage.theActorCalled("actor");
        actor.wasAbleTo(Open.browserOn().the(MainPagePage.class));
    }

    @Given("el usuario abre la página de login {}")
    public void elUsuarioAbreLaPáginaDeLoginData(String prolife) {
        theActorInTheSpotlight().remember(CUSTOMER_DATA, dataPruebas.getCustomerDataWith(prolife));

    }

    @When("ingresa credenciales válidas")
    public void ingresaCredencialesVálidas() {
        Customer customer = theActorInTheSpotlight().recall(CUSTOMER_DATA);

        theActorInTheSpotlight().attemptsTo(
                ProductsAndServices.delTramite(customer.getLogin()),
                OpenForm.delFormulariofront(),
                AddPersonalData.enTheForm(customer.getDataCliente()),
                AddContactData.enElFormulario(customer.getLogin()),
                SignDocument.documents()
        );
    }


    @Then("el sistema redirige al dashboard principal")
    public void elSistemaRedirigeAlDashboardPrincipal() {
        theActorInTheSpotlight().should(
                seeThat(SuccessMessageLinkFormDigital.ofFinishingSuccessful(), Matchers.equalTo(true))
                        .orComplainWith(AccountCreationFailure.class, MESSAGESUCCESLINKFORMDIGITAL.getMessage())
        );
    }


    @When("ingresa credenciales inválidas")
    public void ingresaCredencialesInválidas() {
    }

    @Then("el sistema muestra el mensaje de error Usuario o contraseña incorrectos")
    public void elSistemaMuestraElMensajeDeErrorUsuarioOContraseñaIncorrectos() {
    }


}
