package fr.nimrod.objectrecognition.client.api.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BodyResponse {

   private PredictionResponse[] predictions;
   
}
