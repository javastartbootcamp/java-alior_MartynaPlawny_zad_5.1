package pl.javastart.task;

import java.util.ArrayList;
import java.util.List;

public class Lecturer {
    private final int id;
    private final String degree;
    private final String firstName;
    private final String lastName;
    private static List<Lecturer> lecturerList = new ArrayList<>();

    public Lecturer(int id, String degree, String firstName, String lastName) {
        for (Lecturer lecturer : lecturerList) {
            if (lecturer.id == id) {
                System.out.println("Prowadzący z id " + id + " już istnieje");
            }
        }
        this.id = id;
        this.degree = degree;
        this.firstName = firstName;
        this.lastName = lastName;
        lecturerList.add(this);
    }

    public int getId() {
        return id;
    }

    public String getDegree() {
        return degree;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public static List<Lecturer> getLecturerList() {
        return lecturerList;
    }
}
