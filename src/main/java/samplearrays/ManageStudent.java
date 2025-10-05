package samplearrays;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;

public class ManageStudent {

    // 2) Find the Oldest Student
    public static Student findOldest(Student[] students) {
        if (students.length == 0) return null;

        Student oldest = students[0];

        // Comparing the oldest student to the remainging, if there is a student older than him
        // Assign that student to oldest
        for (int i = 1; i < students.length; i++) {
            if (oldest.getAge() < students[i].getAge()) {
                oldest = students[i];
            }
        }

        return oldest;
    }

    // 3) Count Adult Students (age >= 18)
    public static int countAdults(Student[] students) {
        int adults_count = 0;

        // If a student is adult, increment adults_count
        for (Student student : students) {
            if(student.isAdult()) adults_count++;
        }

        return adults_count;
    }

    // 4) Average Grade (returns NaN if no students or grades)
    public static double averageGrade(Student[] students) {
        double avg_grade = 0;

        // Calculating the sum of grades, then dividing it by the number of students in the array byt casting it
        for (Student student : students) {
            avg_grade += student.getGrade();
        }

        return ((double) avg_grade / students.length);
    }

    // 5) Search by Name (case-sensitive; change to equalsIgnoreCase if desired)
    public static Student findStudentByName(Student[] students, String name) {
        // Comparing the names of students and return the student as long as he have the same name
        for (Student student : students) {
            if(student.getName().equals(name)) return student;
        }

        // If the student is not found return null
        return null;
    }

    // 6) Sort Students by Grade (descending)
    public static void sortByGradeDesc(Student[] students) {
        Student temp;

        // Bubble sort: swapping the two consecutives items if thier order is invalid
        for (int i = students.length - 1; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (students[j].getGrade() < students[j + 1].getGrade()) {
                    temp = students[j + 1];
                    students[j + 1] = students[j];
                    students[j] = temp;
                }
            }
        }
    }

    // 7) Print High Achievers (grade >= 15)
    public static void printHighAchievers(Student[] students) {
        // Printing the student if he had grade more than or equals to 15
        for (Student student : students) {
            if (student.getGrade() >= 15) {
                System.out.println(student.getName());
            }
        }
    }

    // 8) Update Student Grade by id
    public static boolean updateGrade(Student[] students, int id, int newGrade) {
        // searching for the student that have that unique id, and assigning newGrade at that index
        for (int i = 0; i < students.length; i++) {
            if (students[i].getId() == id) {
                students[i].setGrade(newGrade);
                return true;
            }
        }

        // If the id is not found, return false
        return false;
    }

    // 9) Find Duplicate Names
    public static boolean hasDuplicateNames(Student[] students) {
        // Comparing a student's name with other students names, if they are equal return true
        for (int i = 0; i < students.length - 1; i++) {
            for (int j = i + 1; j < students.length; j++) {
                if(students[i].getName().equals(students[j].getName())) {
                    System.out.println("Duplicates found");
                    return true;
                }
            }
        }

        // If none of them have same name return false
        return false;
    }

    // 10) Expandable Array: return a new array with one more slot and append student
    public static Student[] appendStudent(Student[] students, Student newStudent) {
        // Declaring a larger array
        Student[] appendedStudents = new Student[students.length + 1];

        // Copying the oldest array in the first n-1 elements
        for (int i = 0; i < students.length; i++) {
            appendedStudents[i] = students[i];
        }

        // Setting the last item of the new array to the appended element
        appendedStudents[appendedStudents.length - 1] = newStudent;

        // Return that array
        return appendedStudents;
    }

    // 1) Create an Array of Students + demos for all tasks
    public static void main(String[] args) {
        // Create & initialize array of 5 students
        Student[] arr = {
                new Student(1, "Yassine"),
                new Student(2, "Ahmed", 19),
                new Student(3, "Amine", 18, 17),
                new Student(4, "Dina", 20, 19),
                new Student(5, "Yassine", 19)
        };

        // Print all
        System.out.println("== All Students ==");
        for (Student s : arr) System.out.println(s);
        System.out.println("Total created: " + Student.getNumStudent());

        // 2) Oldest
        System.out.println("== Oldest Student ==");
        System.out.println(findOldest(arr));

        // 3) Count adults
        System.out.println("\n== Count Adults ==");
        System.out.println(countAdults(arr));

        // 4) Average grade
        System.out.println("\n== Average Grade ==");
        System.out.println(averageGrade(arr));

        // 5) Find by name
        System.out.println("\n== Find Student By Name ==");
        System.out.println(findStudentByName(arr, "Amine"));

        // 6) Sort by grade desc
        sortByGradeDesc(arr);
        System.out.println("\n== Sorted by grade (desc) ==");
        for (Student s : arr) System.out.println(s);

        // 7) High achievers >= 15
        System.out.println("\nHigh achievers:");
        printHighAchievers(arr);

        // 8) Update grade by id
        boolean updated = updateGrade(arr, 4, 13);
        System.out.println("\nUpdated id=4? " + updated);
        System.out.println(findStudentByName(arr, "Dina"));

        // 9) Duplicate names
        System.out.println("\n== Duplicate Names ==");
        System.out.println(hasDuplicateNames(arr));

        // 10) Append new student
        System.out.println("\n== Append New Student ==");
        Student[] arr2 = appendStudent(arr, new Student(6, "Samir"));
        System.out.println("New array of students: ");
        for (Student s : arr2) System.out.println(s);

        // 11) School Representation
        System.out.println("\n== School Representation ==");
        // Declaring the school: 2D array with each row is a class containing students
        Student[][] school = {
                {
                    new Student(7, "Ossama", 17, 17),
                    new Student(8, "Yasser", 18, 12),
                    new Student(9, "Najib", 18, 18),
                },
                {
                    new Student(10, "Yahya", 19, 20),
                    new Student(11, "Issa", 19, 19),
                    new Student(12, "Adam", 18, 17),
                }
        };

        // Printing students class by class
        for (int i = 0; i < school.length; i++) {
            for (Student student : school[i]) {
                System.out.println("Class: " + i + "," + student);
            }
        }

        // Declaring an array of top student in each class
        Student[] topStudentInEachClass = new Student[school.length];

        // for each class we find the top student using the same logic as the method "findOldest"
        for (int i = 0; i < school.length; i++) {
            topStudentInEachClass[i] = school[i][0];

            for (int j = 1; j < school[i].length; j++) {
                if (topStudentInEachClass[i].getGrade() < school[i][j].getGrade()) {
                    topStudentInEachClass[i] = school[i][j];
                }
            }
        }
        System.out.println("\n== Top Student in Each Class ==");
        for (Student s : topStudentInEachClass) System.out.println(s);
    }
}

