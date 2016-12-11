package fr.nimrod.objectrecognition.client.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import fr.nimrod.objectrecognition.client.api.response.BodyResponse;
import fr.nimrod.objectrecognition.client.api.response.StatusResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown=true)
public class PredictResponse {

   private StatusResponse status;
   
   private BodyResponse body;
}
