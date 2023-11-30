/**
 * @author Ethan Hardy, Jacob Carney, Brian Thomas
 * 
 * Instructor class definition for the University Student Management System
 */

public class Instructor {
    private String name;
    private String prefix;
    private String officeLocation;
    private String department;
    private String email;
    private int instructorID;
    private static int nextInstructID = 100;

// Constructor for creating instructors
    public Instructor(String name, String prefix, String office, String dept, String email) {
        this.name = name;
        this.prefix = prefix;
        this.officeLocation = office;
        this.department = dept;
        this.email = email; 
        this.instructorID = nextInstructID;
        nextInstructID++;
    }

// Setter method for setting the name of an instructor
    public void setName(String name) {
        this.name = name;
    }

// Setter method for setting the prefix of an instructor
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

// Setter method for setting the department of an instructor
    public void setDepartment(String dept) {
        this.department = dept;
    }
    
// Setter method for setting the email of an instructor
    public void setEmail(String email) {
        this.email = email;
    }
    
// Setter method for setting the office of an instructor
    public void setOfficeLocation(String office) {
        this.officeLocation = office; 
    }
    
// Getter method for returning the formal title of an instructor
    public String getTitle() {
        return this.prefix + " " + name;
    }

// Method for returning the instructor object in a string format
    public String toString() {
        String str = String.format("%s", getTitle());
        return str;
    }
}
