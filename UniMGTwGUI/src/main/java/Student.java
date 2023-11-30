/**
 * @author Ethan Hardy, Jacob Carney, Brian Thomas
 * 
 * Student class definition for the University Student Management System
 */

public class Student {
    private String firstName;
    private String lastName;
    private String studentYear;
    private String studentMajor;
    private double GPA;
    private String studentEmail;
    private int studentID;
    private static int nextStudentID = 1000;

// Constructor for creating a student 
    public Student(String name) {
        int index = name.indexOf(" ");
        this.firstName = name.substring(0, index);
        this.lastName = name.substring(index);
        this.studentID = nextStudentID;
        nextStudentID++;
    }

// Overloaded constructor to take more parameters
    public Student(String name, int year, String major, double GPA, String email) {
        int index = name.indexOf(" ");
        this.firstName = name.substring(0, index);
        this.lastName = name.substring(index);
        this.studentMajor = major;
        this.GPA = GPA; 
        this.studentEmail = email; 
        this.studentID = nextStudentID;
        nextStudentID++;
    }
   
// Setter method for setting GPA for a student
    public void setGPA(double GPA) {
            this.GPA = GPA;
    }

// Getter method for returning the GPA of a student
    public double getGPA() {
        return GPA;
    }
    
// Getter method for returning the name of a student
    public String getName() {
        return lastName + ", " + firstName;
    }
    
// Getter method for returning the ID of a student
    public int getStudentID() {
        return this.studentID;
    }

// Setter method for setting the email of a student
    public void setStudentEmail(String email) {
        this.studentEmail = email; 
    }

// Getter method for getting the email of a student
    public String getStudentEmail() {
        return studentEmail;
    }

// Setter method for setting the year of a student
    public void setStudentYear(int year) {
    // Receives the year as an integer and sets the year to the corresponding educational cohort
        switch (year) {
            case (1) : 
                this.studentYear = " Freshman"; 
                break;
            case (2) :
                this.studentYear = " Sophmore";
                break;
            case (3) :
                this.studentYear = " Junior";
                break;
            case (4) :
                this.studentYear = " Senior";
                break;
            default :
                this.studentYear = " Invalid Student Year";
                break;
        }
    }    

// Getter method for returning the year of a student
    public String getStudentYear() {
        return this.studentYear;
    }

// Setter method for setting the major of a student
    public void setStudentMajor(String major) {
        this.studentMajor = major;
    }    

// Getter method for returning the major of a student
    public String getStudentMajor() {
        return studentMajor;
    }
}
