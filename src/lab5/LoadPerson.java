package lab5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.*;
import java.io.*;
import java.text.*;

abstract class LoadPerson
{
    protected static final String DELIMITER = "\\|";

    public LoadPerson()
    {
    }

    public static void main(String[] args) {

        try
        {
            Calendar cal = stringToCal("07/04/1776");
            System.out.println("Calendar Object: "+cal.toString());
            System.out.println("Pretty "+calToPrettyString(cal));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public ArrayList<Person> loadFromFile(String fileNameIn)
    {
        String fileNameOut  = null;
        ArrayList  <Person> personList = new ArrayList<Person> ();
        int rowNum = 0;

        File fileIn = new File(fileNameIn);

        if (! fileIn.exists())
        {
            System.out.println(fileNameIn +" not found");
        }


        Scanner input = null;

        try
        {
            input = new Scanner(fileIn);

            while (input.hasNext())
            {
                String record = input.nextLine();
                Person p = parseRecord(record);
                personList.add(p);
                rowNum++;
            }
            input.close();
        }
        catch (IOException ioe)
        {
            System.out.println("Unable to read  " + fileNameIn + " : " + ioe.getMessage());
            System.exit(1);
        }
        catch (Exception e)
        {
            System.out.println("Exception with " + fileNameIn + " at line "+rowNum+" : " + e.toString());
            e.printStackTrace();
            System.exit(1);
        }
        finally
        {

        }
        return personList;
    }


    public abstract Person parseRecord(String s) throws Exception;

    public static String calToPrettyString(Calendar cal)
    {
        String s = "";
        if (cal != null)
        {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            s = sdf.format(cal.getTime());
        }
        return s;

    }

    public static Calendar stringToCal(String strDate)
            throws Exception
    {
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

        Date date;
        Calendar cal = null;
        try
        {
            date = formatter.parse(strDate);
            cal = Calendar.getInstance();
            cal.setTime(date);
        }
        catch (ParseException e)
        {
            throw new Exception("Invalid date format [" + strDate + "]", e);
        }
        return cal;
    }

}