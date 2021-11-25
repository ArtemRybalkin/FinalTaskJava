package models;

import lombok.Getter;

import java.util.ArrayList;
import java.time.LocalDateTime;

import java.util.List;

import status.Status;

public class AQE extends Student {

    @Getter
    private final List<Course> courseList = new ArrayList<>();

    public AQE(String name, String curriculum, LocalDateTime startDate) {
        super(name, curriculum, startDate);
        courseList.add(new Course("TestDesign", 10, Status.COMPLETE));
        courseList.add(new Course("PageObject", 16, Status.COMPLETE));
        courseList.add(new Course("Selenium", 16, Status.COMPLETE));
    }
}
