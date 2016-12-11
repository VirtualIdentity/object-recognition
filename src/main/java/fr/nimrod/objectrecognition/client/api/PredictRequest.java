package fr.nimrod.objectrecognition.client.api;

import fr.nimrod.objectrecognition.client.api.request.ParameterRequest;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PredictRequest {

   private String service;
   
   private String[] data;
   
   private ParameterRequest parameters;
   
}
