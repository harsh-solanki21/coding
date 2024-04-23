package LowLevelDesign.DesignPatterns.StructuralPatterns.Adapter.Example1;

import java.util.ArrayList;
import java.util.List;

public class StudentClient {

    public List<Student> getStudentList() {
        List<Student> students = new ArrayList<>();

        CollegeStudent collegeStudent = new CollegeStudent("Harsh", "Solanki", "harsh@gmail.com");

        SchoolStudent schoolStudent = new SchoolStudent("H", "S", "hs@gmail.com");

        students.add(collegeStudent);
        students.add(new SchoolStudentAdapter(schoolStudent));

        return students;
    }

}
