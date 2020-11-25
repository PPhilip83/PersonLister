package lab5;

import java.util.Calendar;
import java.util.HashSet;


public class PersonSet {

    public static void main(String[] args) {

        HashSet <Person> al = new HashSet <>();
        al.add(new Person(1, "Mr.", "Walter", "White", Calendar.getInstance()));
        al.add(new Person(5, "Mrs.", "Marie", "Schrader", Calendar.getInstance()));
        al.add(new Person(8, "Mr.", "Saul", "Goodman", Calendar.getInstance()));
        al.add(new Person(4, "Mr.", "Mike", "Erhmantraut", Calendar.getInstance()));
        al.add(new Person(6, "Mrs.", "Jane", "Margolis", Calendar.getInstance()));
        al.add(new Person(7, "Mr.", "Jesse", "Pinkman", Calendar.getInstance()));
        Person p = new Person(7, "Mr.", "Gus", "Fring", Calendar.getInstance());
        al.add(p);

        printList(al);

    }

    private static void printList(HashSet <Person> people) {
        for (Person p : people) {
            System.out.println(p.displayName() + " (" + p.getPersonId() + ")");
        }


    }


}


