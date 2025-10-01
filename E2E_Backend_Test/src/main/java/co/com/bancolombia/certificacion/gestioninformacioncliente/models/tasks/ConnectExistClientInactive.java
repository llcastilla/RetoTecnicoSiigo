package co.com.bancolombia.certificacion.gestioninformacioncliente.models.tasks;

import co.com.bancolombia.certificacion.gestioninformacioncliente.models.Customer;
import co.com.bancolombia.certificacion.gestioninformacioncliente.models.utils.GetProperties;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;


public class ConnectExistClientInactive implements Task {


    Customer customer;

    public ConnectExistClientInactive(Customer customer){
        this.customer = customer;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        String url = GetProperties.get("url.endpoint");
        SerenityRest.reset();

        actor.whoCan(
                CallAnApi.at(url + customer.getIdentificationType() + "/" + customer.getIdentification())
        );
    }

    public static ConnectExistClientInactive alServicio(Customer customer){
        return Instrumented.instanceOf(ConnectExistClientInactive.class).withProperties(customer);
    }
}
