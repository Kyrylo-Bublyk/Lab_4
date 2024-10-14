import Bublyk.Kyrylo.O.model.*;
import Bublyk.Kyrylo.O.controller.*;
import Bublyk.Kyrylo.O.utils.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;

public class UniversityJsonTest {

    @Test
    public void testUniversitySerializationAndDeserialization() throws IOException {
        // Створення університету oldUniversity з двома факультетами на кожному рівні
        UniversityCreator universityCreator = new UniversityCreator();
        FacultyCreator facultyCreator = new FacultyCreator();
        DepartmentCreator departmentCreator = new DepartmentCreator();
        GroupCreator groupCreator = new GroupCreator();
        StudentCreator studentCreator = new StudentCreator();

        University oldUniversity = universityCreator.createUniversity("Test University",
                new Human("Kyrylo", "Bublyk", "O", Sex.MALE)); // Не анонимный класс

        // Додавання факультетів, кафедр, груп та студентів
        for (int i = 1; i <= 2; i++) {
            Faculty faculty = facultyCreator.createFaculty("Faculty " + i, new Human("Head", "Faculty " + i, "Middle", Sex.MALE));
            for (int j = 1; j <= 2; j++) {
                Department department = departmentCreator.createDepartment("Department " + j, new Human("Head", "Department " + j, "Middle", Sex.FEMALE));
                for (int k = 1; k <= 2; k++) {
                    Group group = groupCreator.createGroup("Group " + k, new Human("Head", "Group " + k, "Middle", Sex.MALE));
                    group.addStudent(studentCreator.createStudent("Student " + (k * 2 - 1), "Lastname", "Middle", Sex.MALE));
                    group.addStudent(studentCreator.createStudent("Student " + (k * 2), "Lastname", "Middle", Sex.FEMALE));
                    department.addGroup(group);
                }
                faculty.addDepartment(department);
            }
            oldUniversity.addFaculty(faculty);
        }

        // Запис університету в JSON файл
        JsonManager jsonManager = new JsonManager();
        String filePath = "university.json";
        jsonManager.writeUniversityToFile(oldUniversity, filePath);

        // Читання університету з JSON файлу
        University newUniversity = jsonManager.readUniversityFromFile(filePath);

        // Порівняння oldUniversity та newUniversity
        assertEquals(oldUniversity, newUniversity);
    }
}
