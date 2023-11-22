package pl.javastart.task;

import java.util.Objects;

public class Grade {
    private final int studentIndex;
    private final String groupCode;
    private Student grade;

    public Grade(int studentIndex, String groupCode, double grade) {
        this.studentIndex = studentIndex;
        this.groupCode = groupCode;
        boolean gradeSet = false;
        boolean groupCodeFound = false;

        for (Group group : Group.getGroupList()) {
            if (Objects.equals(group.getCode(), groupCode)) {
                for (Student student : group.getStudentList()) {
                    if (student.getIndex() == studentIndex) {
                        if (student.getFinalGrade() == 0) {
                            student.setFinalGrade(grade);

                            gradeSet = true;
                        } else {
                            System.out.println("Student o indeksie " + studentIndex +
                                    " ma już wystawioną ocenę dla grupy " + groupCode);
                        }
                    }
                }
                groupCodeFound = true;
            }

        }
        if (!groupCodeFound) {
            System.out.println("Grupa " + groupCode + " nie istnieje");
        }
        if (groupCodeFound && !gradeSet) {
            System.out.println("Student o indeksie " + studentIndex + " nie jest zapisany do grupy " + groupCode);
        }
    }
}
