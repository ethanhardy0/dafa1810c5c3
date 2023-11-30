/**
 * @author Ethan Hardy, Jacob Carney, Brian Thomas
 * 
 * Course class definition for the University Student Management System
 */

import java.util.ArrayList;

public class Course {
    private String courseName;
    private String courseBuilding;
    private String courseBldgRoom;
    private int courseCapacity;
    private int courseID;
    private ArrayList<Student> enrolledStudents;
    private Instructor courseInstructor;
    private static int nextCourseID = 0;
    
// Constructor for course objects
    public Course(String name, String building, String room, int capacity) {
        this.courseName = name;
        this.courseBuilding = building;
        this.courseBldgRoom = room;
        this.courseCapacity = capacity;
        this.enrolledStudents = new ArrayList<>();
        this.courseID = nextCourseID;
        nextCourseID++;
    }

// Adds student objects created into enrolledStudents for a course
    public void enrolledStudent(Student newStudent) {
        this.enrolledStudents.add(newStudent);
    }

// Removes students from enrolledStudents from a specified course given a student ID
    public boolean removeStudent(int studentID) {
    // Iterates over the array and returns true if the studentID parameter equals a studentID of a student
        for (int i = 0; i < enrolledStudents.size(); i++) {
            Student student = enrolledStudents.get(i);
            if (student.getStudentID() == studentID) {
                enrolledStudents.remove(i);  
                return true;                 
            }
        }
        return false; 
    }

// Setter method to assign an instructor object to course
    public void assignInstructor(Instructor newInstr) {
        this.courseInstructor = newInstr;
    }

// Setter method for assigning a room to a course
    public void setCourseBldgRoom(String room) {
        this.courseBldgRoom = room; 
    }

// Setter method for assigning a building to a course
    public void setCourseBuilding(String building) { 
        this.courseBuilding = building; 
    }

// Setter method for assigning a capacity of students to a course
    public void setCapacity(int newCapacity) {
        this.courseCapacity = newCapacity; 
    }

// Setter method for naming a course
    public void setCourseName(String name) {
        this.courseName = name; 
    }
    
// Returns a course object in a String format
    public String toString() {  
    // Checks whether an instructor has been added to a course
        String instructorName;
        if (courseInstructor == null) 
            instructorName = "None";
        else 
            instructorName = courseInstructor.getTitle();

        String str = "Course #: " + courseID + " Course: " + courseName + " Building: " + courseBuilding + " Room: " + courseBldgRoom
            + " Capacity: " + courseCapacity + " Instructor of Record: " + instructorName;
        return str;
    }

// Getter method for retrieving students enrolled in a course
    public String getRoster() {
    // Chat helped make this
        StringBuilder str = new StringBuilder();

        for (Student student : this.enrolledStudents) {
            str.append(String.format("StudentID#: %s %s Major: %s Year:%s\n", 
                student.getStudentID(), student.getName(), student.getStudentMajor(), student.getStudentYear()));
        }
        return str.toString();

    }
}
