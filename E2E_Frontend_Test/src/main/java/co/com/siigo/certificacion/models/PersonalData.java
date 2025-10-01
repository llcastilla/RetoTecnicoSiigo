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

        "typeDocument",
        "documentNumber",
        "placeDocumentExpedition",
        "email"


})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class PersonalData {


    @JsonProperty("typeDocument")
    private String typeDocument;

    @JsonProperty("documentNumber")
    private String documentNumber;

    @JsonProperty("placeDocumentExpedition")
    private String placeDocumentExpedition;

    @JsonProperty("email")
    private String email;
}