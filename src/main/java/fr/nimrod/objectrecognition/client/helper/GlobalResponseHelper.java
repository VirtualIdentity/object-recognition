package fr.nimrod.objectrecognition.client.helper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import fr.nimrod.objectrecognition.client.api.PredictResponse;
import fr.nimrod.objectrecognition.client.api.response.ClassesResponse;
import fr.nimrod.objectrecognition.client.api.response.PredictionResponse;
import fr.nimrod.objectrecognition.resources.api.GlobalResponse;
import fr.nimrod.objectrecognition.resources.api.responses.CategorieResponse;
import fr.nimrod.objectrecognition.resources.api.responses.DetectionResponse;
import fr.nimrod.objectrecognition.resources.api.responses.StatusResponse;

@Component
public class GlobalResponseHelper {

   @Value("${deep.detection.limit}")
   private double limitProb;
   
   public GlobalResponse transform(PredictResponse response){
      
      GlobalResponse toReturn = new GlobalResponse();
      
      StatusResponse statusResponse = new StatusResponse();
      statusResponse.setCode(response.getStatus().getCode());
      statusResponse.setMessage(response.getStatus().getMsg());
      
      int index = 0;
      for(PredictionResponse predictionResponse : response.getBody().getPredictions()){
         DetectionResponse detectionResponse = new DetectionResponse();
         detectionResponse.setImage(++index);
         for(ClassesResponse classes : predictionResponse.getClasses()){
            if(classes.getProb() > limitProb){
               CategorieResponse categorie = new CategorieResponse();
               String cat = classes.getCat().substring(classes.getCat().indexOf(" ") + 1);
               categorie.setCat(cat);
               detectionResponse.addCategorie(categorie);
            }
         }
         
         toReturn.addDetection(detectionResponse);
      }
      toReturn.setStatus(statusResponse);
      
      return toReturn;
   }
}
