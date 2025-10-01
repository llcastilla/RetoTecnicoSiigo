package co.com.bancolombia.certificacion.gestioninformacioncliente.models.utils;


import net.thucydides.model.environment.SystemEnvironmentVariables;
import net.thucydides.model.util.EnvironmentVariables;

public class GetProperties {

private GetProperties(){
    throw new IllegalStateException("Utility Class");
}

public static String get(String singlePropertie){
    EnvironmentVariables value = SystemEnvironmentVariables.createEnvironmentVariables();
     return value.getProperty(singlePropertie);
}
}
