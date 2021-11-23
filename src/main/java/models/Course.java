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
    private String status;

    public void setStatus(int allHours, Student student) {

        int sum = 0;
        for (Course course : student.getCourseList()) {
            if (course.getDuration() <= allHours - sum) {
                course.status = Status.COMPLETE.getStatusType();
            } else {
                course.status = Status.NOT_COMPLETE.getStatusType() + " " + (course.getDuration() - (allHours - sum)) + " hours left";
            }
            sum += course.getDuration();
        }
    }
}
