import java.util.HashMap;
import java.util.Map;

public class AQE extends Student {
    static Map<String, Integer> courses = new HashMap<>();

    {
        AQE.courses.put("TestDesign", 10);
        AQE.courses.put("PageObject", 16);
        AQE.courses.put("Selenium", 16);
    }

    @Override
    public Map<String, Integer> getCourses() {
        return AQE.courses;
    }

    @Override
    public int getDurCourses() {
        return (courses.get("TestDesign") + courses.get("PageObject") + courses.get("Selenium"));
    }

    public AQE(String name, String CURRICULUM, String startDate, Map<String, Integer> courses) {
        super(name, CURRICULUM, startDate, courses);
    }
}
