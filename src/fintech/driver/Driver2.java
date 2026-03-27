package fintech.driver;

import fintech.model.*;
import java.util.*;

/**
 * @author 12S24007 - Dasmauli Sormin
 */

 public class Driver2 {
     static final String DATA_SEPARATOR = "#";
     static Student[] students = new Student[0];

     public static void main(String[] _args) {
         Scanner scanner = new Scanner(System.in);
         String line = null;

         while(true) {
             line = scanner.nextLine();

             if(line.equals("---")) {
                 break;
             }
             String[] data = line.split(DATA_SEPARATOR);
             Student newStudent = arrayToStudent(data);
             addStudent(newStudent);
         }

         printAllOfStudents();
         scanner.close();
     }

    private static void printAllOfStudents() {
         for(Student student : students) {
             System.out.println(student);
         }
     }

     private static void addStudent(Student student) {
         students = Arrays.copyOf(students, students.length + 1);
         students[students.length - 1] = student;
     }

     private static Student arrayToStudent(String[] data) {
        Student student = new Student(data[0], data[1], data[2], data[3]);
         return student;
     }
 }