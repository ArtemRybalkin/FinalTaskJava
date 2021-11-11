import java.util.HashMap;
import java.util.Map;

public class AQE extends Student {
    static Map<String, Integer> Courses = new HashMap<String, Integer>();

    public void setCourses() {
        AQE.Courses.put("TestDesign",10);
        AQE.Courses.put("PageObject",16);
        AQE.Courses.put("Selenium",16);
    }
    @Override
    public Map getCourses() {
        setCourses();
        return AQE.Courses;
    }
    @Override
    public int getDurCourses() {
        setCourses();
        int durAQECourseDays = (Courses.get("TestDesign").intValue() + Courses.get("PageObject").intValue() +
                Courses.get("Selenium").intValue());
        int durAQECourseHours = (Courses.get("TestDesign").intValue() + Courses.get("PageObject").intValue()
                + Courses.get("Selenium").intValue())%8;
        return durAQECourseDays;
    }

    public AQE(String name, String CURRICULUM, String startDate, Map courses) {
        super(name, CURRICULUM, startDate, courses);
    }
}
