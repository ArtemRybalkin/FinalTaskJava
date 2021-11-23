package models;
import lombok.Getter;
import status.Status;

import java.util.ArrayList;
import java.util.List;

public class Developer extends Student {
    @Getter
    private  final List<Course> courseList = new ArrayList<>();

    public Developer(String name, String curriculum, String startDate) {
        super(name, curriculum, startDate);
        courseList.add(new Course("Java", 16, Status.NOT_COMPLETE.getStatusType()));
        courseList.add(new Course("JDBC", 24, Status.NOT_COMPLETE.getStatusType()));
        courseList.add(new Course("Spring", 16, Status.NOT_COMPLETE.getStatusType()));
    }
}
