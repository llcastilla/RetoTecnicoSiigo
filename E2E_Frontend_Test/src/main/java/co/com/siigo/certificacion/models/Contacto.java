package co.com.siigo.certificacion.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "nombre",
        "apellido",
        "correo",
        "cargo",
        "indicativo",
        "telefono"

})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Contacto {

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("apellido")
    private String apellido;


    @JsonProperty("correo")
    private String correo;

    @JsonProperty("cargo")
    private String cargo;

    @JsonProperty("indicativo")
    private String indicativo;

    @JsonProperty("telefono")
    private String telefono;

}