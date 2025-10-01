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
        "numId",
        "country",
        "holderName",
        "ProductNumber",
        "tramite"
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ContactData {

    @JsonProperty("numId")
    private String numId;

    @JsonProperty("country")
    private String country;

    @JsonProperty("holderName")
    private String holderName;

    @JsonProperty("ProductNumber")
    private String ProductNumber;

    @JsonProperty("tramite")
    private String tramite;
}