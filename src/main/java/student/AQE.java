package student;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


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
        int sum = 0;
        for (Integer courseDuration : courseDurations) {
            sum += courseDuration;
        }
        return sum;
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
