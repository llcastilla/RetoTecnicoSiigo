package co.com.siigo.certificacion.models.tasks;


import co.com.siigo.certificacion.models.utils.Constants;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;


public class Consumerdetails implements Task {

    String query;
    public Consumerdetails(String query){
        this.query = query;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to("")
                .with( requestSpecification -> requestSpecification
                .contentType("application/json")
                .header("Authorization","Bearer "+ Constants.TOKEN)
                .relaxedHTTPSValidation()
                .body(query)
                )



        );

System.out.println("token:" +Constants.TOKEN);
        System.out.println("token:" +query);

    }

    public static Consumerdetails elServicio(String query){
        return Instrumented.instanceOf(Consumerdetails.class).withProperties(query);
    }
}
