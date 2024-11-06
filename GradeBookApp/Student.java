/*
    White, Andrew. (2024). CIS 505 Intermediate Java Programming.
    Bellevue University
*/
package GradeBookApp;

// This Java class defines the attributes of a student
public class Student {
    // Private data fields for student info
    private String firstName;
    private String lastName;
    private String courseName;
    private String grade;

    // No-argument constructor to create a default student
    public Student() {
        
    }

    // Argument constructor to create a student with specified values
    public Student(String firstName, String lastName, String courseName, String grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.courseName = courseName;
        this.grade = grade;
    }

    // Accessor and Mutator methods for variables (getters/setters)
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getGrade() {
        return grade;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    // Override the toString method to provide a formatted string for student
    @Override
    public String toString() {
        return String.format("%-20s %-20s %-20s %-5s", firstName, lastName, courseName, grade);

    }
}
