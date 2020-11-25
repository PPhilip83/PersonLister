package lab5;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Comparator;

public class Person implements Comparable <Person>, Comparator <Person> {
    private int personId;
    private String title;
    private String firstName;
    private String lastName;
    private Calendar birthDate;

    public int getPersonId() {
        return personId;
    }   
    
    Person() {
    }
    
    Person (int personId, String title, String firstName, String lastName, Calendar birthDate) {
        this.personId = personId;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        sb.append("PersonId " + this.getPersonId() + "\n");
        sb.append("Title " + this.getTitle() + "\n");
        sb.append("First Name " + this.getFirstName() + "\n");
        sb.append("Last Name " + this.getLastName() + "\n");
        sb.append("Birth Date " + prettyCal(this.getBirthDate()) + "\n");
        return sb.toString();
    }
    
    
    public String displayName() {
        StringBuilder sb = new StringBuilder("");
        sb.append(this.getTitle().trim() + " ");
        sb.append(this.getFirstName().trim() + " ");
        sb.append(this.getLastName().trim() + " ");
        return sb.toString();
    }
    
    public String prettyCal(Calendar cal) {
        String s = "";
        if (cal != null) {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyy");
            s = sdf.format(cal.getTime());
        }
        return s;
    }
    
    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }  

    @Override
    public int compareTo(Person o) {
        String s1 = this.getLastName() + " " + this.getFirstName();
        String s2 = o.getLastName() + " " + o.getFirstName();
        return s1.toUpperCase().compareTo(s2.toUpperCase());
    }
    
    @Override
    public int compare(Person p1, Person p2) {
        Integer i1 = new Integer(p1.getPersonId());
        Integer i2 = new Integer(p2.getPersonId());
        //String s1 = p1.getPersonId() + " " + p1.getLastName() + " " + p1.getFirstName();
        //String s2 = p2.getPersonId() + " " + p2.getLastName() + " " + p2.getFirstName();
        return i1.compareTo(i2);
    }
}
