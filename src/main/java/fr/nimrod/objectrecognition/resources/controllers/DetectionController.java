package fr.nimrod.objectrecognition.resources.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.nimrod.objectrecognition.resources.api.DetectionRequest;
import fr.nimrod.objectrecognition.resources.api.GlobalResponse;
import fr.nimrod.objectrecognition.resources.api.responses.DetectionResponse;
import fr.nimrod.objectrecognition.resources.api.responses.ImageResponse;
import fr.nimrod.objectrecognition.resources.api.responses.StatusResponse;

@RestController
public class DetectionController {

   @PostMapping(value = "/detection")
   public GlobalResponse callDetection(@RequestBody DetectionRequest request) {

      StatusResponse status = new StatusResponse();
      status.setCode(200);
      status.setMessage("Fake response");
      DetectionResponse detectionResponse = new DetectionResponse();

      List<ImageResponse> images = new ArrayList<>();
      for (String data : request.getData()) {
         ImageResponse image = new ImageResponse();
         image.setCat("something");
         images.add(image);
      }

      ImageResponse[] imagesResponse = new ImageResponse[images.size()]; 
      detectionResponse.setImages(images.toArray(imagesResponse));
      
      GlobalResponse response = new GlobalResponse();
      response.setStatus(status);
      response.setDetections(detectionResponse);
      return response;
   }
}
