import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AQE extends Student {
//    @Getter
    static List<String> courseNames = new ArrayList<>();
//    @Getter
    static List<Integer> courseDurations = new ArrayList<>();

    public List<String> getCourseNames() {
        return courseNames;
    }

    public List<Integer> getCourseDuration() {
        return courseDurations;
    }

    public int getDurAllCourses() {
        return (courseDurations.get(0) + courseDurations.get(1) + courseDurations.get(2));
    }

    public AQE(String name, String CURRICULUM, String startDate) {
        super(name, CURRICULUM, startDate, courseNames, courseDurations);
        courseNames.add(0, "TestDesign");
        courseNames.add(1, "PageObject");
        courseNames.add(2, "Selenium");
        courseDurations.add(0, 10);
        courseDurations.add(1, 16);
        courseDurations.add(2, 16);
    }
}
