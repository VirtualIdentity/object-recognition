package fr.nimrod.objectrecognition.resources.api.responses;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetectionResponse {

   private int image;
   
   private List<CategorieResponse> categories;
  
   public boolean addCategorie(CategorieResponse categorie){
      if(categories == null){
         categories = new ArrayList<>();
      }
      if(!categories.contains(categorie)){
         return categories.add(categorie);
      }
      
      return false;
   }
}
