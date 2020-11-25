package lab5;

import java.util.ArrayList;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import java.util.List;
import java.util.Collections;

public class Lab5 extends Application {
    
    private static String PROGRAMNAME = "lab5";

    private static String USAGE = "Usage: " + PROGRAMNAME;

    private static final String DELIMITER = "\\|";
    
    private Label lblTitle = new Label("Title");
    private Label lblId = new Label("Id");
    private Label lblFirstName = new Label("First Name");
    private Label lblLastName = new Label("Last Name");
    private Label lblType = new Label("Type");
    private Label lblBirthDate = new Label("Birth Date");
    private Label lblClass = new Label("Class");
    private Label lblDegrees = new Label("Degrees");
    private Label lblDisplayName = new Label("Display Name");
    private Label lblToString = new Label("ToString");
    
    
    public TextField tfId = new TextField();
    public TextField tfFirstName = new TextField();
    public TextField tfLastName = new TextField();
    public TextField tfDegrees1 = new TextField();
    public TextField tfDegrees2 = new TextField();
    public TextField tfDegrees3 = new TextField();
    public TextField tfDegrees4 = new TextField();
    public TextField tfDegrees5 = new TextField();
    public TextField tfDisplayName = new TextField();
    
    private TextArea taToString = new TextArea();

    public String[] titles = {"Mr.", "Mrs.", "Ms.", "Dr."};
    ObservableList<String> titleOptions = FXCollections.observableArrayList(titles);
    private ComboBox cbTitle = new ComboBox(titleOptions);
    
    private DatePicker dpBirthDt = new DatePicker();
    
    private Button btnSubmit = new Button("Submit");
    private Button btnReset = new Button("Reset");
    
    
    private RadioButton rbFaculty = new RadioButton("Faculty");
    private RadioButton rbStudent = new RadioButton("Student");
    
    public String[] classification = {"Freshman", "Sophomore", "Junior", "Senior"};
    ObservableList<String> classOptions = FXCollections.observableArrayList(classification);
    private ComboBox cbClass = new ComboBox(classOptions);
    @Override
    
    public void start(Stage primaryStage) {
        
        HBox paneRadio = new HBox();
        GridPane root = new GridPane();
        
        tfId.setMaxWidth(100);
        
        root.add(lblId,0,0);
        tfId.setPromptText("Numerical value");
        root.add(tfId,1,0);
        
        root.add(lblTitle,0,1);
        root.add(cbTitle,1,1);
        
        root.add(lblFirstName,0,2);
        root.add(tfFirstName,1,2);
        tfFirstName.setPromptText("No white space");
        
        root.add(lblLastName,0,3);
        root.add(tfLastName,1,3);
        tfLastName.setPromptText("No white space");
        
        root.add(lblBirthDate,0,4);
        root.add(dpBirthDt,1,4);
        
        root.add(lblType,0,5);
        
        ToggleGroup tg = new ToggleGroup();
        rbFaculty.setToggleGroup(tg);
        rbStudent.setToggleGroup(tg);
        paneRadio.getChildren().addAll(rbFaculty, rbStudent);
        root.add(paneRadio,1,5);
        rbFaculty.setSelected(true);
        rbStudent.setSelected(false);
        
        rbFaculty.setOnAction(e -> processFaculty());
        rbStudent.setOnAction(e -> processStudent());
        
        root.add(lblClass,0,6);
        root.add(cbClass,1,6);
        
        lblClass.setVisible(false);
        cbClass.setVisible(false);
        
        root.add(lblDegrees,0,7);
        root.add(tfDegrees1,1,7);
        tfDegrees1.setPromptText("PhD");
        root.add(tfDegrees2,1,8);
        tfDegrees2.setPromptText("MBA");
        root.add(tfDegrees3,1,9);
        tfDegrees3.setPromptText("BA");
        root.add(tfDegrees4,1,10);
        tfDegrees4.setPromptText("AA");
        root.add(tfDegrees5,1,11);
        tfDegrees5.setPromptText("etc");
        

        root.add(btnSubmit,0,12);
        root.add(btnReset,1,12);
        
        btnSubmit.setOnAction(e -> processSubmit());
        btnReset.setOnAction(e -> processReset());
        
        root.add(lblDisplayName,0,13);
        root.add(tfDisplayName,1,13);
        root.add(lblToString,0,14);
        root.add(taToString,1,14);
        
        lblDisplayName.setVisible(false);
        tfDisplayName.setVisible(false);
        lblToString.setVisible(false);
        taToString.setVisible(false);
        
        root.setVgap(5);
        root.setHgap(5);
        Insets insets = new Insets(5,5,5,5);
        
        Scene scene = new Scene(root, 600, 500);
        root.setPadding(insets);
     
        
        primaryStage.setTitle("Person Entry");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void processFaculty() {
        lblClass.setVisible(false);
        cbClass.setVisible(false);
        lblDegrees.setVisible(true);
        tfDegrees1.setVisible(true);
        tfDegrees2.setVisible(true);
        tfDegrees3.setVisible(true);
        tfDegrees4.setVisible(true);
        tfDegrees5.setVisible(true);
    }
        
    public void processStudent() {
        lblClass.setVisible(true);
        cbClass.setVisible(true);
        lblDegrees.setVisible(false);
        tfDegrees1.setVisible(false);
        tfDegrees2.setVisible(false);
        tfDegrees3.setVisible(false);
        tfDegrees4.setVisible(false);
        tfDegrees5.setVisible(false);
    }
    
    public void processSubmit() {
        lblDisplayName.setVisible(true);
        tfDisplayName.setVisible(true);
        lblToString.setVisible(true);
        taToString.setVisible(true);
        
        int idNumber = Integer.parseInt(this.tfId.getText());
        
        String selectedTitle = "";
        int titleIndex = titleOptions.indexOf(cbTitle.getValue());
        if (titleIndex >= 0)
        {
            selectedTitle =  titles[titleIndex];
        }
        
        String firstName = tfFirstName.getText();
        String lastName = tfLastName.getText();
        
        
        if (rbFaculty.isSelected()) {
            
            String degree1 = tfDegrees1.getText();
            String degree2 = tfDegrees2.getText();
            String degree3 = tfDegrees3.getText();
            String degree4 = tfDegrees4.getText();
            String degree5 = tfDegrees5.getText();
            
            ArrayList<String> enteredDegrees = new ArrayList<String>();
            enteredDegrees.add(degree1);
            enteredDegrees.add(degree2);
            enteredDegrees.add(degree3);
            enteredDegrees.add(degree4);
            enteredDegrees.add(degree5);
            
            Faculty faculty = new Faculty();
            faculty.setPersonId(idNumber);
            faculty.setTitle(selectedTitle);
            faculty.setFirstName(firstName);
            faculty.setLastName(lastName);
            faculty.setDegrees(enteredDegrees);
            
            tfDisplayName.setText(faculty.displayName());
            taToString.setText(faculty.toString());
        }
        
        if (rbStudent.isSelected()) {}
            
            String selectedClass = "";
            int classIndex = classOptions.indexOf(cbClass.getValue());
            if (classIndex >= 0)
            {
                selectedClass =  classification[classIndex];
            }
        
            Student student = new Student();
            student.setPersonId(idNumber);
            student.setTitle(selectedTitle);
            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.setClassification(selectedClass);
            
            tfDisplayName.setText(student.displayName());
            taToString.setText(student.toString());
            
    }
    
    public void processReset() {
        tfId.setText("");
        tfFirstName.setText("");
        tfLastName.setText("");
        cbTitle.getSelectionModel().clearSelection();
        taToString.setText("");
        cbClass.getSelectionModel().clearSelection();
        rbFaculty.setSelected(true);
        tfDegrees1.setText("");
        tfDegrees2.setText("");
        tfDegrees3.setText("");
        tfDegrees4.setText("");
        tfDegrees5.setText("");
        lblDisplayName.setVisible(false);
        tfDisplayName.setVisible(false);
        lblToString.setVisible(false);
        taToString.setVisible(false);
    }
    
        public Lab5() {

    }
        
public static void main(String[] args) {

        String studentFile = "students.txt";
        String facultyFile = "faculty.txt";

        LoadStudent loadStudent = new LoadStudent();
        ArrayList <Person> studentList = loadStudent.loadFromFile(studentFile);

        Collections.sort(studentList, new Person());
        Collections.sort(studentList);
        System.out.println("Students==============================");
        printList(studentList);

        System.out.println("\n***********\n");

        LoadFaculty loadFaculty = new LoadFaculty();
        ArrayList <Person> facultyList = loadFaculty.loadFromFile(facultyFile);
        Collections.sort(facultyList, new Person());
        System.out.println("Lab5.Faculty==============================");
        printList(facultyList);

        System.out.println("\n***********\n");

        ArrayList <Person> personList = new ArrayList <Person>();
        personList.addAll(facultyList);
        personList.addAll(studentList);
        Collections.sort(personList);
        System.out.println("Everybody==============================");
        printList(personList);

        System.out.println("\n***********\n");

        Collections.sort(personList, new Person());
        System.out.println("Everybody sorted by ID===========================");
        printList(personList);


    }

    public static void printList(List <Person> people) {
        for (Person p : people) {
            System.out.println(p.displayName() + "   (" + p.getPersonId() + ")");
        }

    }
    
}