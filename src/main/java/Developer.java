import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        return (courseDurations.get(0) + courseDurations.get(1) + courseDurations.get(2));
    }

    public Developer(String name, String CURRICULUM, String startDate) {
        super(name, CURRICULUM, startDate, courseNames, courseDurations);

        courseNames.add("Java");
        courseNames.add("JDBC");
        courseNames.add("Spring");
        courseDurations.add(0, 16);
        courseDurations.add(1, 24);
        courseDurations.add(2, 16);
    }
}
