package co.com.bancolombia.certificacion.gestioninformacioncliente.models.tasks;


import co.com.bancolombia.certificacion.gestioninformacioncliente.models.utils.Constants;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;
import net.serenitybdd.screenplay.rest.interactions.Put;


public class ConsumerPut implements Task {

    String query;
    public ConsumerPut(String query){
        this.query = query;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(

                Put.to(Constants.EMPTY)
                .with(requestSpecification -> requestSpecification
                .contentType("application/json")
                .header("Authorization","Bearer "+ Constants.TOKEN)
            //                    .header("Authorization","Bearer "+ "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsImtpZCI6IkNOdjBPSTNSd3FsSEZFVm5hb01Bc2hDSDJYRSJ9.eyJhdWQiOiJhYmIxYThiOS02NTFmLTRiNDgtODViYi05NTBhYmE2MDU3OTciLCJpc3MiOiJodHRwczovL2xvZ2luLm1pY3Jvc29mdG9ubGluZS5jb20vNDI4ZjRlMmUtMTNiZi00ODg0LWIzNjQtMDJlZjlhZjQxYTFkL3YyLjAiLCJpYXQiOjE3NDU4NzUzMTMsIm5iZiI6MTc0NTg3NTMxMywiZXhwIjoxNzQ1ODgwOTM4LCJhaW8iOiJBWVFBZS84WkFBQUFDbVNlQlFaaHV5RjdFRkNlNEV3QjdtdFVCUVlYREUyLzBWQWpJOW43cEQ3ZDhwc1FoMWVDQ1ZUbGZNR1dHQURXM3NpRDdlTlVhakZKS0RDbkliLzZjdHdjSTNvUEQ4RS9IWGZuTUF4akxCOG4xcUVQZVo0LzExMHUxRUJ2MUM5TzFMVzRkTDBZRFZvbjdFZkh2ZjFxWWFsaWFjaElabS9hUXNhNXpDL2pkZWc9IiwiYXpwIjoiYWJiMWE4YjktNjUxZi00YjQ4LTg1YmItOTUwYWJhNjA1Nzk3IiwiYXpwYWNyIjoiMCIsImdyb3VwcyI6WyJBX0tJVENBUElUQUxfQURNSU5JU1RSQURPUl9PVyIsIkFfS0lUQ0FQSVRBTF9WSU5DVUxBQ0lPTiIsIkFfS0lUQ0FQSVRBTF9NT05JVE9SRU8iLCJBX0tJVENBUElUQUxfQURNSU5JU1RSQURPUiIsIkFfS0lUQ0FQSVRBTF9URVNPUkVSSUEiLCJBX0tJVENBUElUQUxfQVNFU09SQ09NRVJDSUFMX0lOVkVSIiwiQV9LSVRDQVBJVEFMX0dFU1RJT05BQ0NFU09TIiwiQV9LSVRDQVBJVEFMX0dFUkVOVEVDT01FUkNJQUxfSU5WRVIiLCJBX0tJVENBUElUQUxfR0VSRU5URVJFR0lPTkFMX0lOVkVSIiwiQV9LSVRDQVBJVEFMX1JJRVNHT0RFTUVSQ0FETyIsIkFfS0lUQ0FQSVRBTF9QQVJBTUVUUklaQUNJT04iXSwibmFtZSI6Ikp1YW4gRXN0ZWJhbiBWYWxlbmNpYSBBcmVuYXMiLCJvaWQiOiI1ZmRlOTI5Yy1mMzQ3LTRkZjMtOTk2MS1iMGE0OGRhZjA4NjMiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJqdWV2YWxlbkBhbWJpZW50ZXNiYy5jb20iLCJyaCI6IjEuQVNVQUxrNlBRcjhUaEVpelpBTHZtdlFhSGJtb3Nhc2ZaVWhMaGJ1VkNycGdWNWNsQUlNbEFBLiIsInJvbGVzIjpbIkFETUlOSVNUUkFDSU9OX09XIiwiVklOQ1VMQUNJT04iLCJNT05JVE9SRU8iLCJTVVBFUlVTRVIiLCJURVNPUkVSSUEiLCJBU0VTT1JDT01FUkNJQUwiLCJHRVNUSU9OQUNDRVNPUyIsIkdFUkVOVEVDT01FUkNJQUwiLCJHRVJFTlRFUkVHSU9OQUwiLCJSSUVTR09ERU1FUkNBRE8iLCJQQVJBTUVUUklaQUNJT04iXSwic2NwIjoiZGVmYXVsdCIsInNpZCI6IjAwNDE1NmE5LTI0YzMtZGIzOS1jNjk2LWRkMzcxMTJiYmEzNSIsInN1YiI6Ik9hUDZjZWNaRVAwYTFzbUxMNmdqVDUzUHRwUERGeFRzVUhhcmp5YTdRTTgiLCJ0aWQiOiI0MjhmNGUyZS0xM2JmLTQ4ODQtYjM2NC0wMmVmOWFmNDFhMWQiLCJ1dGkiOiJsclI2MllXRkZFeUpVZEdQUmpDUEFBIiwidmVyIjoiMi4wIn0.EdVBzcigtWQJH1L9Onhw1QBfrcsbLe6E98DAnhxxjwwKWqrU3uBFP-ePSdwrvrEXdupVMDNhx7mml2GJEMb37Tm7-b7juJ4kCYlIebBtURuGLK4l6LMpTs4IvPTAjudWPqAqzQKHCHwna5bEp08Zv5uQ4k2jsgk49mhe1_u1v2AOO0X8Pqu0cvSpLay3epIYLQwVhRTYvL6VOINjobgTx6w_moCIGUO07M-pn0jEJHSyUNIW_csN9HSBG09rnCHjrXkrtoIfMG2xul-yOHxygYIep6fptytoRafG3rD3uag_5l2pvNaVc-HZLOM2yc3k9kNhk_Bn8rxOrdDAUiq38Q")
                .relaxedHTTPSValidation()
                .body(query)
                )



        );

System.out.println("token:" +Constants.TOKEN);
        System.out.println("query:" +query);

    }

    public static ConsumerPut elServicio(String query){
        return Instrumented.instanceOf(ConsumerPut.class).withProperties(query);
    }
}
