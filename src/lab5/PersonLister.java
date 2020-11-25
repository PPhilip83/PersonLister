package lab5;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class PersonLister {
        public static void main(String[] args) {
            ArrayList<Person> al = new ArrayList<>();
            
            al.add( new Person (1, "Mr.", "Homer", "Simpson", Calendar.getInstance()));
            al.add( new Person(2, "Mrs.", "Marge", "Simpson", Calendar.getInstance()));
            al.add( new Person(3, "Mr.", "Bart", "Simpson", Calendar.getInstance()));
            al.add(new Person(4, "Mr.", "Waylon", "Smithers", Calendar.getInstance()));
            al.add(new Person(5, "Mr.", "C", "Burns", Calendar.getInstance()));
            al.add(new Person (6, "Ms.", "Edna", "Krabappel", Calendar.getInstance()));
            
            Collections.sort(al, new Person());
            printList(al);
            
            System.out.println("");
            
            Collections.sort(al);
            printList(al);
            
    }
    
        private static void printList(ArrayList<Person> people) {
            
            for (Person p: people) {
                System.out.println(p.displayName() + " " + p.getPersonId());
            }
        }     
}
