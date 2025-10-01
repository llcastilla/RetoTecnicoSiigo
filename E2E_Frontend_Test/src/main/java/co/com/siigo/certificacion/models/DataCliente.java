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
        "indice",
        "nombreComercial",
        "ciudad",
        "direccion",
        "codigoPostal"
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

    @JsonProperty("indice")
    private String indice;

    @JsonProperty("nombreComercial")
    private String nombreComercial;

    @JsonProperty("ciudad")
    private String ciudad;

    @JsonProperty("direccion")
    private String direccion;


    @JsonProperty("codigoPostal")
    private String codigoPostal;
}