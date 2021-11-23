package models;

import lombok.Getter;
import status.Status;

import java.util.ArrayList;
import java.util.List;

public class AQE extends Student {
    @Getter
    private final List<Course> courseList = new ArrayList<>();

    public AQE(String name, String curriculum, String startDate) {
        super(name, curriculum, startDate);
        courseList.add(new Course("TestDesign", 10, Status.NOT_COMPLETE.getStatusType()));
        courseList.add(new Course("PageObject", 16, Status.NOT_COMPLETE.getStatusType()));
        courseList.add(new Course("Selenium", 16, Status.NOT_COMPLETE.getStatusType()));
    }
}
