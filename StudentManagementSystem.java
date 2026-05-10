import java.io.*;
import java.util.*;

class Student {
    int rollNo;
    String name;
    String course;
    double marks;

    Student(int rollNo, String name, String course, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return rollNo + " - " + name + " - " + course + " - " + marks;
    }
}

public class StudentManagementSystem {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: searchStudent(); break;
                case 4: updateStudent(); break;
                case 5: deleteStudent(); break;
                case 6: System.exit(0);
                default: System.out.println("Invalid choice!");
            }
        }
    }

    static void addStudent() {
        System.out.print("Enter Roll No: ");
        int roll = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Course: ");
        String course = sc.nextLine();
        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        students.add(new Student(roll, name, course, marks));
        System.out.println("Student Added Successfully!");
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
        } else {
            for (Student s : students) {
                System.out.println(s);
            }
        }
    }

    static void searchStudent() {
        System.out.print("Enter Roll No to search: ");
        int roll = sc.nextInt();
        for (Student s : students) {
            if (s.rollNo == roll) {
                System.out.println("Found: " + s);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    static void updateStudent() {
        System.out.print("Enter Roll No to update: ");
        int roll = sc.nextInt();
        sc.nextLine();
        for (Student s : students) {
            if (s.rollNo == roll) {
                System.out.print("Enter New Name: ");
                s.name = sc.nextLine();
                System.out.print("Enter New Course: ");
                s.course = sc.nextLine();
                System.out.print("Enter New Marks: ");
                s.marks = sc.nextDouble();
                System.out.println("Student Updated!");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    static void deleteStudent() {
        System.out.print("Enter Roll No to delete: ");
        int roll = sc.nextInt();
        Iterator<Student> itr = students.iterator();
        while (itr.hasNext()) {
            if (itr.next().rollNo == roll) {
                itr.remove();
                System.out.println("Student Deleted!");
                return;
            }
        }
        System.out.println("Student not found.");
    }
}