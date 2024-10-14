package Bublyk.Kyrylo.O.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Faculty {
    private String name;
    private Human head;
    private List<Department> departments;

    public Faculty(String name, Human head) {
        this.name = name;
        this.head = head;
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public String getName() {
        return name;
    }

    public Human getHead() {
        return head;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Faculty)) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals(name, faculty.name) &&
                Objects.equals(head, faculty.head) &&
                Objects.equals(departments, faculty.departments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, head, departments);
    }
}

