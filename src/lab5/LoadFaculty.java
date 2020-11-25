package lab5;

import java.text.ParseException;
import java.util.*;

public class LoadFaculty extends LoadPerson {

    public static void main(String[] args) {

    }

    @Override
    public Person parseRecord(String s) throws Exception {
        Faculty faculty = null;
        try {
            String[] lineRead = s.split("\\|");
            int id = Integer.parseInt(lineRead[0]);
            String title = lineRead[1];
            String fName = lineRead[2];
            String lName = lineRead[3];
            String bDate = lineRead[4];
            ArrayList <String> degreesList = new ArrayList <>(Collections.singleton(lineRead[5]));
            faculty = new Faculty(id, title, fName, lName, stringToCal(bDate), degreesList);
        } catch (NullPointerException | ParseException e) {
            System.out.println(e.getLocalizedMessage());
        }

        return faculty;

    }
}
