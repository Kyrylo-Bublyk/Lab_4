package Bublyk.Kyrylo.O.controller;

import Bublyk.Kyrylo.O.model.University;
import Bublyk.Kyrylo.O.model.Human;

public class UniversityCreator {
    public University createUniversity(String name, Human head) {
        return new University(name, head);
    }
}
