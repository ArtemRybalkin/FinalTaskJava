import java.util.HashMap;
import java.util.Map;

public class Developer extends Student {
    static Map<String, Integer> courses = new HashMap<>();

    {
        courses.put("Java", 16);
        courses.put("JDBC", 24);
        courses.put("Spring", 16);
    }

    @Override
    public Map<String, Integer> getCourses() {
        return courses;
    }

    @Override
    public int getDurCourses() {
        return (courses.get("Java") + courses.get("JDBC") + courses.get("Spring"));
    }

    public Developer(String name, String CURRICULUM, String startDate, Map<String, Integer> courses) {
        super(name, CURRICULUM, startDate, courses);
    }
}
