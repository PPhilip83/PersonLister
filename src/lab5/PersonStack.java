
package lab5;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Stack;

public class PersonStack {
        public static void main(String[] args) {
            Stack<Person> al = new Stack<>();
            
            al.push( new Person (1, "Mr.", "Homer", "Simpson", Calendar.getInstance()));
            al.push( new Person(2, "Mrs.", "Marge", "Simpson", Calendar.getInstance()));
            al.push( new Person(3, "Mr.", "Bart", "Simpson", Calendar.getInstance()));
            al.push(new Person(4, "Mr.", "Waylon", "Smithers", Calendar.getInstance()));
            al.push(new Person(5, "Mr.", "C", "Burns", Calendar.getInstance()));
            al.push(new Person (6, "Ms.", "Edna", "Krabappel", Calendar.getInstance()));

            System.out.println(al.pop().displayName());  
    }   
        private static void printList(List<Person> people) {
            
            for (Person p: people) {
                System.out.println(p.displayName() + " " + p.getPersonId());
            }
        }
}
