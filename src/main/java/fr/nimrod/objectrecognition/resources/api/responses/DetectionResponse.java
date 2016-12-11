package fr.nimrod.objectrecognition.resources.api.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetectionResponse {

   private ImageResponse[] images;
  
}
