package models;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

public class AQE extends Student {
    @Getter
    List<Course> courseList = new ArrayList<>();
    public AQE(String name, String curriculum, String startDate) {
        super(name, curriculum, startDate);
        courseList.add(new Course("TestDesign", 10));
        courseList.add(new Course("PageObject", 16));
        courseList.add(new Course("Selenium", 16));
    }
}
