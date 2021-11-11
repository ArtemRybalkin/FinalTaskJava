import java.util.HashMap;
import java.util.Map;

public class Developer extends Student{
    static Map<String, Integer> Courses = new HashMap<String, Integer>();

    public void setCourses () {
        Courses.put("Java",16);
        Courses.put("JDBC",24);
        Courses.put("Spring",16);
    }

    @Override
    public Map getCourses() {
        setCourses();
        return Courses;
    }

    @Override
    public int getDurCourses() {
        setCourses();
        int durDevCourseDays = (Courses.get("Java").intValue() + Courses.get("JDBC").intValue() + Courses.get("Spring").intValue());
        int durDevCourseHours = (Courses.get("Java").intValue() + Courses.get("JDBC").intValue() + Courses.get("Spring").intValue())%8;
        return durDevCourseDays;
    }

    public Developer(String name, String CURRICULUM, String startDate, Map courses) {
        super(name, CURRICULUM, startDate, courses);
    }
}
