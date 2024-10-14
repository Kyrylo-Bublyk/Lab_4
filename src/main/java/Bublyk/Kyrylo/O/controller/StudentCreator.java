package Bublyk.Kyrylo.O.controller;

import Bublyk.Kyrylo.O.model.Student;
import Bublyk.Kyrylo.O.model.Sex;

public class StudentCreator {
    public Student createStudent(String firstName, String lastName, String middleName, Sex gender) {
        return new Student(firstName, lastName, middleName, gender);
    }
}
