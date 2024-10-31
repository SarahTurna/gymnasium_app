/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trainer;

import Classes.Member;
import Classes.WorkoutRoutine;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Ac
 */
public class Create_and_personalize_workout_routinesController implements Initializable {

    @FXML
    private BorderPane borderpane;
    @FXML
    private DatePicker datepicker;
    @FXML
    private ComboBox<String> workoutType;
    @FXML
    private TextField timesTextField;
    @FXML
    private Pane viewTablePane;
    @FXML
    private TableView<WorkoutRoutineList> WorkoutRoutineTableview;
    @FXML
    private TableColumn<WorkoutRoutineList, LocalDate> dateColumn;
    @FXML
    private TableColumn<WorkoutRoutineList, String> memberIDColumn;
    @FXML
    private TableColumn<WorkoutRoutineList, String> workoutColumn;
    @FXML
    private TableColumn<WorkoutRoutineList, String> timesColumn;

    private ArrayList<Member> memArray = new ArrayList<Member>();
    @FXML
    private TextField memberIDTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        workoutType.getItems().addAll("PushUps","Pullups","");

        viewTablePane.setVisible(false);
        
    }    
   

    @FXML
    private void BacktoDashboardButtonOnClick(ActionEvent event) throws IOException {
        BorderPane pane;
        pane = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
        borderpane.getChildren().setAll(pane);
    }
  

    @FXML
    private void AddWorkoutButtonOnClick(ActionEvent event) throws IOException {
        
           String memID = memberIDTextField.getText();
           String workType =workoutType.getValue();
           LocalDate selectedDate = datepicker.getValue();
           System.out.println("Selected date: " + selectedDate);
           String Time =  timesTextField.getText();
           
        
                 WorkoutRoutine WR = new WorkoutRoutine(memID, workType, selectedDate, Time);


         workoutType.getItems().clear();
         timesTextField.clear();
       datepicker.setValue(null);
    
 }

    @FXML
    private void ViewRoutineButtonOnClick(ActionEvent event) {
        viewTablePane.setVisible(true);
       
        String memID = memberIDTextField.getText();
        File f = null;
        try {
         f = new File(memID+"_WorkoutRoutine.txt");  
        Scanner scan;
        if(f.exists()) {
        scan = new Scanner(f);
        while (scan.hasNextLine()) {
            String[] parts = scan.nextLine().split("//");
            if (parts.length == 4) {
                String memberId = parts[0];
                String workoutName = parts[1];
                LocalDate localDate = LocalDate.parse(parts[2]);
                String times = parts[3];
                 WorkoutRoutineList workout = new WorkoutRoutineList(memberId,workoutName,localDate,times);
                
                 WorkoutRoutineTableview.getItems().add(workout);
            }
        }
    }
    else{
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("File not found");
        alert.setHeaderText(null);
        alert.setContentText("Member: " + memID + " file not found.");
        alert.showAndWait();
    }
        } catch (IOException ex) {
            System.out.println("Error In table view load table ");
        } finally {

            System.out.println("Ob List Data ");
        }

// Populate the table with the data
    
        memberIDColumn.setCellValueFactory(new PropertyValueFactory<>("memID"));
        workoutColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("dateAssigned"));
        timesColumn.setCellValueFactory(new PropertyValueFactory<>("tableTime"));
    }
}

  

   
