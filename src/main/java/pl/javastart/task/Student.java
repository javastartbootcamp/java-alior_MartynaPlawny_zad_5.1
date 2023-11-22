package pl.javastart.task;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student {
    private int index;
    private String groupCode;
    private String firstName;
    private String lastName;

    private double finalGrade = 0;

    public void setFinalGrade(double finalGrade) {
        this.finalGrade = finalGrade;
    }

    static List<Student> studentList = new ArrayList<>();

    public Student(int index, String groupCode, String firstName, String lastName) {
        this.index = index;
        this.firstName = firstName;
        this.lastName = lastName;
        for (Student student : studentList) {
            if (student.index == index) {
                System.out.println("Student o indeksie " + index + " jest już w grupie " + groupCode);
            }
        }
        studentList.add(this);
        boolean groupExist = false;
        for (Group group : Group.getGroupList()) {
            if (Objects.equals(group.getCode(), groupCode)) {
                this.groupCode = groupCode;
                group.addToStudentList(this);
                groupExist = true;
            }
            if (groupExist == false) {
                System.out.println("Grupa " + groupCode + " nie istnieje");
            }
        }
    }

    public int getIndex() {
        return index;
    }

    public double getFinalGrade() {
        return finalGrade;
    }

    public String getGroupCode() {
        return groupCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static List<Student> getStudentList() {
        return studentList;
    }
}
