package com.school.management.model;
import java.util.list;
public class course {
    private String courseId;
    private String courseName;
    private String courseDescription;
    private int courseCredits;
    private int courseCapacity;
    private List<Student> enrolledStudents;


    public course(String courseId, String courseName, String courseDescription, int courseCredits, int courseCapacity) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
        this.courseCredits = courseCredits;
        this.courseCapacity = courseCapacity;
        this.enrolledStudents = new ArrayList<>();
    }

    boolean isFull() {
        return enrolledStudents.size() >= courseCapacity;
    }

    boolean isStudentEnrolled(Student student) {
        return enrolledStudents.contains(student);
    }

    boolean enrollStudent(Student student) {
        if (isFull()) {
            return false;
        }
        enrolledStudents.add(student);
        return true;
    }
    boolean unenrollStudent(Student student) {
        return enrolledStudents.remove(student);
    }
    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }
    public String getCourseDescription() {
        return courseDescription;
    }
    public int getCourseCredits() {
        return courseCredits;
    }
    public int getCourseCapacity() {
        return courseCapacity;
    }
    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }
    void displayCourseDetails(){
        system.out.println("Course ID: " + courseId);
        system.out.println("Course Name: " + courseName);
        system.out.println("Course Description: " + courseDescription);
        system.out.println("Course Credits: " + courseCredits);
        system.out.println("Course Capacity: " + courseCapacity);
        system.out.println("Enrolled Students: " + enrolledStudents.size());
    }

    
}