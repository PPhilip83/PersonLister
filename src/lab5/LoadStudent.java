package lab5;


public class LoadStudent extends LoadPerson {

    public static void main(String[] args) {

    }

    @Override
    public Person parseRecord(String s) throws Exception {
        Student student = null;
        try {
            String[] lineRead = s.split("\\|");
            int id = Integer.parseInt(lineRead[0]);
            String title = lineRead[1];
            String fName = lineRead[2];
            String lName = lineRead[3];
            String bDate = lineRead[4];
            String stYear = lineRead[5];
            student = new Student(id, title, fName, lName, stringToCal(bDate), stYear);
        } catch (NullPointerException e) {
            System.out.println(e.getLocalizedMessage());
        }
        return student;
    }
}
