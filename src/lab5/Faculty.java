
package lab5;

import java.util.ArrayList;
import java.util.Calendar;

public class Faculty extends Person{
    private ArrayList<String> degrees;

    Faculty() {
    }
    
    Faculty (int personId, String title, String firstName, String lastName, Calendar birthDate, ArrayList<String> degrees) {
        super(personId, title, firstName, lastName, birthDate);
        setDegrees(degrees);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("Degrees " + degrees);
        return sb.toString();
    }
    
    @Override
    public String displayName() {
        StringBuilder sb = new StringBuilder(super.displayName());
        if (degrees.size() > 0) {
            sb.append(", ");
            sb.append(degrees.get(0));
        }
        return sb.toString();
    }
    
    public ArrayList<String> getDegrees() {
        return degrees;
    }

    public void setDegrees(ArrayList<String> degrees) {
        this.degrees = degrees;
    }
    
    
}
