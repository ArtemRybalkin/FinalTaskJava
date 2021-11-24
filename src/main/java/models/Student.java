package models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
public abstract class Student {
    @Getter
    private final String name;
    @Getter
    private final String curriculum;
    @Getter
    private final LocalDateTime startDate;

    public abstract List<Course> getCourseList();

    public int getSumDurationAllCourses (){
        int sum = 0;
        for (Course course : getCourseList()) {
            sum += course.getDuration();
        }
        return sum;
    }
}
