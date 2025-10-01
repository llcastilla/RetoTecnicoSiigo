package co.com.bancolombia.certificacion.utils.natural_person;

import co.com.bancolombia.certificacion.exeptions.CouldNotReadTheJsonExeption;
import co.com.bancolombia.certificacion.models.natural_person.Customer;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DataPanamaSubsidiary {

    private static final String RUTA = "src/test/resources/data/natural_person/panama_subsidiary/";
    private static final String EXTENCION = ".json";

    private DataPanamaSubsidiary(){}

    @SneakyThrows
    public static Customer getCustomerDataWith(String profile){

        ObjectMapper mapper = new ObjectMapper();
        JavaType type = mapper.getTypeFactory().constructType(Customer.class);

        return mapper.readValue(searchCustomerData(profile), type);

    }

    @SneakyThrows
    private static String searchCustomerData(String perfil) {
        String data;
        String ruta = RUTA + perfil + EXTENCION;

        try {
            data = Files.readString(Paths.get(ruta));
        } catch (IOException e) {
            throw new CouldNotReadTheJsonExeption("No sepudo leer el json" + ruta,e);
        }

        return data;
    }

}
