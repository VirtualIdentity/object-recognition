package fr.nimrod.objectrecognition.resources.api;

import java.util.ArrayList;
import java.util.List;

import fr.nimrod.objectrecognition.resources.api.responses.DetectionResponse;
import fr.nimrod.objectrecognition.resources.api.responses.StatusResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GlobalResponse {

   private StatusResponse status;
   
   private List<DetectionResponse> detections;
   
   public boolean addDetection(DetectionResponse detection){
      if(detections == null){
         detections = new ArrayList<>();
      }
      if(!detections.contains(detection)){
         return detections.add(detection);
      }
      return false;
   }
}
