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
        "correo",
        "contraseña"
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class LoginError {

    @JsonProperty("correo")
    private String correo;

    @JsonProperty("contraseña")
    private String contrasena;

}