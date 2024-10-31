/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trainer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Ac
 */
public class WorkoutRoutineList {
    String memID, type, tableTime;
    LocalDate  dateAssigned;

    public WorkoutRoutineList(String memberId, String workoutName, LocalDate localDate, String times) {
        this.memID = memberId;
        this.type = workoutName;
        this.tableTime = times;
        this.dateAssigned = localDate;
    }

    public void setMemID(String memID) {
        this.memID = memID;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setTableTime(String tableTime) {
        this.tableTime = tableTime;
    }

    public void setDateAssigned(LocalDate dateAssigned) {
        this.dateAssigned = dateAssigned;
    }

    public String getMemID() {
        return memID;
    }

    public String getType() {
        return type;
    }

    public String getTableTime() {
        return tableTime;
    }

    public LocalDate getDateAssigned() {
        return dateAssigned;
    }

   

}