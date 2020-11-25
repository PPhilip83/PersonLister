
package lab5;

import java.util.Calendar;

public class Student extends Person{
    private String classification;

    Student() {
    }
    
    Student (int personId, String title, String firstName, String lastName, Calendar birthDate, String classification) {
        super(personId, title, firstName, lastName, birthDate);
        setClassification(classification);
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Classification " + classification);
        return sb.toString();
    }
    
    
    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }
    
    
}
