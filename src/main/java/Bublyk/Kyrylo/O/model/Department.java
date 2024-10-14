package Bublyk.Kyrylo.O.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Department {
    private String name;
    private Human head;
    private List<Group> groups;

    public Department(String name, Human head) {
        this.name = name;
        this.head = head;
        this.groups = new ArrayList<>();
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public List<Group> getGroups() {
        return groups;
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
        if (!(o instanceof Department)) return false;
        Department department = (Department) o;
        return Objects.equals(name, department.name) &&
                Objects.equals(head, department.head) &&
                Objects.equals(groups, department.groups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, head, groups);
    }
}
