package Bublyk.Kyrylo.O.controller;

import Bublyk.Kyrylo.O.model.Department;
import Bublyk.Kyrylo.O.model.Human;

public class DepartmentCreator {
    public Department createDepartment(String name, Human head) {
        return new Department(name, head);
    }
}
