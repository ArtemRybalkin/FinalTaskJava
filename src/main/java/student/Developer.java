package student;

import java.util.ArrayList;
import java.util.List;

public class Developer extends Student {
    private static final List<String> courseNames = new ArrayList<>();
    private static final List<Integer> coursesDuration = new ArrayList<>();

    public Developer(String name, String curriculum, String startDate) {
        super(name, curriculum, startDate, courseNames, coursesDuration);
        setCourseNames("Java");
        setCourseNames("JDBC");
        setCourseNames("Spring");
        setCoursesDuration(16);
        setCoursesDuration(24);
        setCoursesDuration(16);
    }

}
