package pl.javastart.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Group {
    private final String code;
    private final String name;
    private final int lecturerId;
    private Lecturer lecturer;

    public Lecturer getLecturer() {
        return lecturer;
    }

    static List<Group> groupList = new ArrayList<>();
    List<Student> studentList = new ArrayList<>();

    public Group(String code, String name, int lecturerId) {
        for (Group group : groupList) {
            if (Objects.equals(group.code, code)) {
                System.out.println("Grupa " + code + " już istnieje");
            }
        }
        this.code = code;
        this.name = name;
        this.lecturerId = lecturerId;
        groupList.add(this);

        for (Lecturer lecturer : Lecturer.getLecturerList()) {
            if (lecturer.getId() == lecturerId) {
                this.lecturer = lecturer;
            }
        }
    }

    public void addToStudentList(Student student) {
        this.studentList.add(student);
    }

    public static List<Group> getGroupList() {
        return groupList;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getLecturerId() {
        return lecturerId;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public static void addStudentToGroup() {

    }

    @Override
    public String toString() {
        return "Group{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", lecturerId=" + lecturerId +
                ", studentList=" + studentList +
                '}';
    }
}
