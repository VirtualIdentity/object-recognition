package fr.nimrod.objectrecognition.client.helper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import fr.nimrod.objectrecognition.client.api.PredictRequest;
import fr.nimrod.objectrecognition.client.api.request.InputRequest;
import fr.nimrod.objectrecognition.client.api.request.MllibRequest;
import fr.nimrod.objectrecognition.client.api.request.OutputRequest;
import fr.nimrod.objectrecognition.client.api.request.ParameterRequest;

@Component
public class PredictRequestHelper {

   @Value("${deep.service.name}")
   private String serviceName;
   
   @Value("${deep.parameters.input.width}")
   private int width;
   
   @Value("${deep.parameters.input.height}")
   private int height;
   
   @Value("${deep.parameters.output.best}")
   private int best;
   
   @Value("${deep.parameters.mllib.gpu}")
   private boolean gpu;
   
   public PredictRequest createPredictRequest(String[] datas){
      
      InputRequest input = new InputRequest();
      input.setHeight(height);
      input.setWidth(width);
      
      OutputRequest output = new OutputRequest();
      output.setBest(best);
      
      MllibRequest mllib = new MllibRequest();
      mllib.setGpu(gpu);
      
      ParameterRequest parameters = new ParameterRequest();
      parameters.setInput(input);
      parameters.setMllib(mllib);
      parameters.setOutput(output);
      
      PredictRequest predictRequest = new PredictRequest();
      predictRequest.setData(datas);      
      predictRequest.setService(serviceName);
      predictRequest.setParameters(parameters);
      
      return predictRequest;
   }
}
