package models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import status.Status;

@AllArgsConstructor
public class Course {

    @Getter
    private final String name;
    @Getter
    private final int duration;
    @Getter
    private Status status;

    public void setStatus(int workedHours, Student student) {

        int sum = 0;
        for (Course course : student.getCourseList()) {
            if (course.getDuration() >= workedHours - sum) {
                course.status = Status.NOT_COMPLETE;
            }
            sum += course.getDuration();
        }
    }
}
