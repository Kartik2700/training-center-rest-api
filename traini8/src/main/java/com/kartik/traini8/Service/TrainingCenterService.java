package com.kartik.traini8.Service;

import com.kartik.traini8.Model.TrainingCenter;
import com.kartik.traini8.Repository.TrainingCenterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Indicates that class is a service component
public class TrainingCenterService {

    @Autowired
    private TrainingCenterRepo trainingCenterRepo;

    //Creates a new training center and saves it to the database.
    public ResponseEntity<TrainingCenter> createTrainingCenter(TrainingCenter trainingCenter) {
        TrainingCenter savedCenter = (TrainingCenter) trainingCenterRepo.save(trainingCenter);//// Save the training center to the database
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCenter); // Return the saved entity
    }


    //Retrieves all training centers from the database.
    public List<TrainingCenter> findAllTrainingCenters() {
        List<TrainingCenter> allCenters = trainingCenterRepo.findAll();// Fetch all training centers from the database
        return allCenters; // Return the list of all training centers
    }
}
