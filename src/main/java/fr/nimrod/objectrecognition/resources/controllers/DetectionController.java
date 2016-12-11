package fr.nimrod.objectrecognition.resources.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.nimrod.objectrecognition.client.services.PredictService;
import fr.nimrod.objectrecognition.resources.api.DetectionRequest;
import fr.nimrod.objectrecognition.resources.api.GlobalResponse;

@RestController
public class DetectionController {

   @Autowired
   private PredictService servicePrediction;

   @PostMapping(value = "/detection")
   public GlobalResponse callDetection(@RequestBody DetectionRequest request) {
     
      return servicePrediction.callPrediction(request.getData());

   }
}
