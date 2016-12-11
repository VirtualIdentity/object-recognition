package fr.nimrod.objectrecognition.resources.api;

import fr.nimrod.objectrecognition.resources.api.responses.DetectionResponse;
import fr.nimrod.objectrecognition.resources.api.responses.StatusResponse;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GlobalResponse {

   private StatusResponse status;
   
   private DetectionResponse detections;
}
