package fr.nimrod.objectrecognition.client.api.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParameterRequest {

   private InputRequest input;
   
   private OutputRequest output;
   
   private MllibRequest mllib;
}
