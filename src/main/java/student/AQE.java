package student;

import java.util.ArrayList;
import java.util.List;

public class AQE extends Student {
    static List<String> courseNames = new ArrayList<>();
    static List<Integer> courseDurations = new ArrayList<>();

    public AQE(String name, String CURRICULUM, String startDate) {
        super(name, CURRICULUM, startDate, courseNames, courseDurations);
        setCourseNames("TestDesign");
        setCourseNames("PageObject");
        setCourseNames("Selenium");
        setCoursesDuration(10);
        setCoursesDuration(16);
        setCoursesDuration(16);
    }
}
