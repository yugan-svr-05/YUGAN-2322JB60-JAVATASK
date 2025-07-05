package day05;

import java.util.ArrayList;
import java.util.Iterator;

public class StudentList {
    public static void main(String[] args) {
        // Create an ArrayList of Student
        ArrayList<Student> students = new ArrayList<>();

        // Add Student objects to the list
        students.add(new Student("Alice", 18, "A"));
        students.add(new Student("Bob", 19, "B"));
        students.add(new Student("Charlie", 20, "A"));

        // Display students using Iterator
        System.out.println("Student List:");
        Iterator<Student> iterator = students.iterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();
            student.display();
        }
    }
}
