package com.school.management.model;

import java.util.HashMap;
import java.util.Map;
import com.school.management.exception.GradeOutOfBoundsException;
import com.school.management.exception.StudentNotFoundException; 

public class Student extends Person {
    
    private Map<Course, Double> grades;

    public Student(String id, String name, String email) {
        super(id, name, email);
        this.grades = new HashMap<>(); 
    }

    public void enrollInCourse(Course course) {
        if (course.enrollStudent(this)) {
            // 2. Add course to the map with a default value (null grade) upon enrollment
            grades.put(course, null); 
            System.out.println("Student " + getName() + " enrolled in course " + course.getTitle());
        } else {
            System.out.println("Course " + course.getTitle() + " is full. Enrollment failed.");
        }
    }

    public void addGrade(Course course, double grade) throws GradeOutOfBoundsException, StudentNotFoundException {
        // 3. Check enrollment using the map keys instead of a broken boolean flag
        if (!grades.containsKey(course)) {
            throw new StudentNotFoundException("Student is not enrolled in this course.");
            // No need for 'break' here because 'throw' immediately exits the method.
        }

        // 4. Validate grade boundary
        if (grade < 0 || grade > 20) {
            throw new GradeOutOfBoundsException("Grade must be between 0.0 and 20.0");
        }

        // 5. Save the grade
        grades.put(course, grade);
    }

    @Override
    public void displayInfo() {
        System.out.println("Student: " + getName() + " [ID: " + getId() + "]");
    }
    
    // Getter for transcript if needed later
    public Map<Course, Double> getGrades() {
        return grades;
    }
}