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
        "NumId",
        "codSucursal",
        "indicativo",
        "telefono",
        "ext",
        "nombreComercial",
        "ciudad",
        "direccion"
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class DataCliente {

    @JsonProperty("NumId")
    private String NumId;

    @JsonProperty("codSucursal")
    private String codSucursal;


    @JsonProperty("indicativo")
    private String indicativo;

    @JsonProperty("telefono")
    private String telefono;

    @JsonProperty("ext")
    private String ext;

    @JsonProperty("nombreComercial")
    private String nombreComercial;

    @JsonProperty("ciudad")
    private String ciudad;

    @JsonProperty("direccion")
    private String direccion;
}