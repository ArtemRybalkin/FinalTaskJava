package models;
import lombok.Getter;
import status.Status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Developer extends Student {
    @Getter
    private  final List<Course> courseList = new ArrayList<>();

    public Developer(String name, String curriculum, LocalDateTime startDate) {
        super(name, curriculum, startDate);
        courseList.add(new Course("Java", 16, Status.COMPLETE));
        courseList.add(new Course("JDBC", 24, Status.COMPLETE));
        courseList.add(new Course("Spring", 16, Status.COMPLETE));
    }
}
