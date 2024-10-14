package Bublyk.Kyrylo.O.controller;

import Bublyk.Kyrylo.O.model.Faculty;
import Bublyk.Kyrylo.O.model.Human;

public class FacultyCreator {
    public Faculty createFaculty(String name, Human head) {
        return new Faculty(name, head);
    }
}
