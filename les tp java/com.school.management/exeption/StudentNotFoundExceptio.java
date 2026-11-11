package com.school.management.exeption;

public class gradeOutOfBoundsException extends RuntimeException {
    public GradeOutOfBoundsException(String message) {
        super(message);
    }
}