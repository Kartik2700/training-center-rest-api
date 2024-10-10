package com.kartik.traini8.Controller;

import com.kartik.traini8.Model.TrainingCenter;
import com.kartik.traini8.Service.TrainingCenterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Marking class as Rest Controller ,Used to Create RESTful web services
@RequestMapping("api/training-centers") //Base url for this controller
public class TrainingCenterController {

    @Autowired //Automatic dependency injection
    private TrainingCenterService trainingCenterService;

    //Creating new  training center
    @PostMapping// Maps POST request for creating a training centers
    public ResponseEntity<TrainingCenter> createTrainingCenter(@Valid @RequestBody TrainingCenter trainingCenter){
      return trainingCenterService.createTrainingCenter(trainingCenter);//calling service method to create  the training center
    }


    //Retrieve all training center
    @GetMapping// Maps GET request to retrieve all training centers
    public ResponseEntity<List<TrainingCenter>> getAllTrainingCenters() {
        List<TrainingCenter> centers = trainingCenterService.findAllTrainingCenters();//Fetch all the training centers
        return ResponseEntity.ok(centers); // Return the list of training centers
    }


}
