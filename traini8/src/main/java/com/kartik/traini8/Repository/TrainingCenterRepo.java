package com.kartik.traini8.Repository;

import com.kartik.traini8.Model.TrainingCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/*
    Repository interface for TrainingCenter entity.
    Extends JpaRepository to provide CRUD operations.
 */
@Repository
public interface TrainingCenterRepo extends JpaRepository<TrainingCenter,String> {

}
