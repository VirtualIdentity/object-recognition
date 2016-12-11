package fr.nimrod.objectrecognition.client.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fr.nimrod.objectrecognition.client.api.PredictRequest;
import fr.nimrod.objectrecognition.client.api.PredictResponse;
import fr.nimrod.objectrecognition.client.helper.GlobalResponseHelper;
import fr.nimrod.objectrecognition.client.helper.PredictRequestHelper;
import fr.nimrod.objectrecognition.resources.api.GlobalResponse;

@Service
public class PredictService {

   @Autowired
   private PredictRequestHelper predictRequestHelper;
   
   @Autowired
   private GlobalResponseHelper globalResponseHelper;
   
   @Autowired
   private RestTemplate restTemplate;
   
   @Value("${deep.url}")
   private String urlBase;
   
   public GlobalResponse callPrediction(String[] datas){
      
      PredictRequest request = predictRequestHelper.createPredictRequest(datas);
      
      ResponseEntity<PredictResponse> response = restTemplate.postForEntity(urlBase + "/predict", request, PredictResponse.class);
      
      return globalResponseHelper.transform(response.getBody());
      
   }
}
