package student;

import java.util.ArrayList;
import java.util.List;

public class Developer extends Student {

    static List<String> courseNames = new ArrayList<>();
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

    public Developer(String name, String CURRICULUM, String startDate) {
        super(name, CURRICULUM, startDate, courseNames, courseDurations);
        courseNames.add(0, "Java");
        courseNames.add(1, "JDBC");
        courseNames.add(2, "Spring");
        courseDurations.add(0, 16);
        courseDurations.add(1, 24);
        courseDurations.add(2, 16);
    }
}
