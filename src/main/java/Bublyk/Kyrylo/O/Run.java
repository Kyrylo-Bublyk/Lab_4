package Bublyk.Kyrylo.O;

import Bublyk.Kyrylo.O.controller.*;
import Bublyk.Kyrylo.O.model.*;

public class Run {
    public static void main(String[] args) {
        Run run = new Run();
        University university = run.createTypicalUniversity();
        run.printUniversityStructure(university);
    }

    public University createTypicalUniversity() {
        UniversityCreator universityCreator = new UniversityCreator();
        FacultyCreator facultyCreator = new FacultyCreator();
        DepartmentCreator departmentCreator = new DepartmentCreator();
        GroupCreator groupCreator = new GroupCreator();
        StudentCreator studentCreator = new StudentCreator();

        // Створення голови університету
        Human universityHead = new Human("Kyrylo", "Bublyk", "Olegovych", Sex.MALE) {};

        // Створення університету
        University university = universityCreator.createUniversity("NTU", universityHead);

        // Створення факультету
        Human facultyHead = new Human("Alex", "Kazarynov", "Valeriyovich", Sex.MALE) {};
        Faculty faculty = facultyCreator.createFaculty("Faculty of Engineering", facultyHead);

        // Створення кафедри
        Human departmentHead = new Human("Oksana", "Gerasyvna", "Sergeevna", Sex.FEMALE) {};
        Department department = departmentCreator.createDepartment("Department of Computer Science", departmentHead);

        // Створення групи
        Human groupHead = new Human("Alex", "Alexeev", "Alexandrovich", Sex.MALE) {};
        Group group = groupCreator.createGroup("Group 124-21-2", groupHead);

        // Додавання студентів
        group.addStudent(studentCreator.createStudent("Erik", "Boghutski", "Olegovych", Sex.MALE));
        group.addStudent(studentCreator.createStudent("Liza", "Kazarivna", "Sergeevna", Sex.FEMALE));

        // Додавання підрозділів
        department.addGroup(group);
        faculty.addDepartment(department);
        university.addFaculty(faculty);

        return university;
    }

    public void printUniversityStructure(University university) {
        System.out.println("Університет: " + university.getName());
        System.out.println("Голова університету: " + university.getHead().getFullName());
        for (Faculty faculty : university.getFaculties()) {
            System.out.println("\tФакультет: " + faculty.getName());
            System.out.println("\tГолова факультету: " + faculty.getHead().getFullName());
            for (Department department : faculty.getDepartments()) {
                System.out.println("\t\tКафедра: " + department.getName());
                System.out.println("\t\tГолова кафедри: " + department.getHead().getFullName());
                for (Group group : department.getGroups()) {
                    System.out.println("\t\t\tГрупа: " + group.getName());
                    System.out.println("\t\t\tСтароста групи: " + group.getHead().getFullName());
                    System.out.println("\t\t\tСтуденти:");
                    for (Student student : group.getStudents()) {
                        System.out.println("\t\t\t\t- " + student.getFullName() + " (" + student.getGender() + ")");
                    }
                }
            }
        }
    }
}