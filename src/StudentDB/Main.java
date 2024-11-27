package StudentDB;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main 
{
    public static void main(String[] args) throws FileNotFoundException  
    {
        while (true) 
        {
            Scanner input = new Scanner(System.in);
            
            System.out.printf("%nPlease Choose between the following:%n" 
            + "1. Create Student%n" 
            + "2. Read All Student%n" 
            + "3. Update Student%n" 
            + "4. Delete Student%n" 
            + "5. Exit%n");
            int selection = input.nextInt();
            input.nextLine();

            switch (selection) 
            {
            case 1 -> createStudent(input);
            case 2 -> readStudent();
            case 3 -> updateStudent(input);
            case 4 -> deleteStudent(input);
            case 5 -> 
            {
                System.out.println("Exiting...");
                return;
            }
            default -> System.out.println("Invalid selection please try again");
            }
        }
    }

    public static void createStudent(Scanner input)
    {
        try 
        {
            
            System.out.print("Enter Student Name: ");
            String name = input.nextLine();

            System.out.print("Enter Student ID: ");
            int id = input.nextInt();
            input.nextLine();
    
            System.out.print("Enter Student Year: ");
            int year = input.nextInt();
            input.nextLine(); 

            Student student = new Student();
            student.setName(name);
            student.setId(id);
            student.setYear(year);

            saveCreateSudent("Database.txt", student);
            System.out.println("File successfully saved");
        } 
        catch (InputMismatchException e) 
        {
            System.out.println("Please input numeric only for Student ID/Year");
        }   
    }

    public static void saveCreateSudent(String filename, Student student) 
    {
        try(FileWriter fileWriter = new FileWriter(filename,true))
        {
            File file = new File(filename);
            if (file.length() == 0) 
            {
                fileWriter.write("Student name, Student id, Student year");
            }
            fileWriter.write(student.getName()+
            " "+student.getId()+
            " "+student.getYear());
        } 
        catch (IOException e) 
        {
            System.out.println("An error occurred while saving the file.");
            e.printStackTrace();
        }
    }
  
    public static void readStudent()
    {
        String line = null;
       try 
       {
           FileReader fileReader = new FileReader("Database.txt");

           BufferedReader bufferedReader = new BufferedReader(fileReader);

           while((line = bufferedReader.readLine()) !=null) 
           {
             System.out.println(line);
           }

           bufferedReader.close();
       } 
       catch (IOException e) 
       {
            System.out.println("Error reading file named");
       }
    }

    public static void updateStudent(Scanner input)
    {
        System.out.println("test 3");
    }

    public static void deleteStudent(Scanner input) 
    {
        System.out.println("test 4");
    }
}