package models;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
@AllArgsConstructor
public abstract class Student {
    @Getter
    private final String name;
    @Getter
    private final String curriculum;
    @Getter
    private final String startDate;

    public abstract List<Course> getCourseList();

}
