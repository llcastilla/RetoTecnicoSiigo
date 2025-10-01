package co.com.bancolombia.certificacion.stepdefinitions.manual_form;

import co.com.bancolombia.certificacion.exeptions.AccountCreationFailure;

import co.com.bancolombia.certificacion.models.natural_person.Customer;


import co.com.bancolombia.certificacion.questions.natural_person.SuccessMessageLink;
import co.com.bancolombia.certificacion.tasks.natural_person.*;

import co.com.bancolombia.certificacion.userinterfaces.natural_person.MainPagePage;
import co.com.bancolombia.certificacion.utils.natural_person.DataPanamaSubsidiary;

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


import static co.com.bancolombia.certificacion.utils.Constants.*;
import static co.com.bancolombia.certificacion.utils.WordsToRemember.CUSTOMER_DATA;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;


public class CollectionFrontStep {

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

    @Given("is a Panama person {}")
    public void isAPanamaPerson(String prolife) {
        theActorInTheSpotlight().remember(CUSTOMER_DATA, DataPanamaSubsidiary.getCustomerDataWith(prolife));
    }

    @When("the customer fills out all required fields in the form with valid and complete information")
    public void theCustomerFillsOutAllRequiredFieldsInTheFormWithValidAndCompleteInformation() {

        Customer customer = theActorInTheSpotlight().recall(CUSTOMER_DATA);

        theActorInTheSpotlight().attemptsTo(
                ProductsAndServices.delTramite(customer.getContactData()),
                OpenForm.delFormulariofront(),
                AddPersonalData.enTheForm(customer.getPersonalData()),
                UploadDocument.ofSupport()
        );

    }

    @Then("the system should display a confirmation message indicating successful form submission and processing start")
    public void theSystemShouldDisplayAConfirmationMessageIndicatingSuccessfulFormSubmissionAndProcessingStart() {
        theActorInTheSpotlight().should(
                seeThat(SuccessMessageLink.ofFinishingSuccessful(), Matchers.equalTo(true))
                        .orComplainWith(AccountCreationFailure.class, MESSAGESUCCESLINK.getMessage())
        );
    }

}
