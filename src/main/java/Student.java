import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public abstract class Student {

    private final String name;
    private final String CURRICULUM;
    private final String startDate;
    private final Map<String, Integer> courses;

    public String getName() {
        return name;
    }

    public String getCurr() {
        return CURRICULUM;
    }

    public String getStartDate() {
        return startDate;
    }

    public Map<String, Integer> getCourses() {
        return courses;
    }

    public abstract int getDurCourses();

    public List<String> getCourseNames() {
        return new ArrayList<>(courses.keySet());
    }

    public List<Integer> getCourseDuration() {
        return new ArrayList<>(courses.values());
    }

    public Student(String name, String CURRICULUM, String startDate, Map<String, Integer> courses) {
        this.name = name;
        this.CURRICULUM = CURRICULUM;
        this.startDate = startDate;
        this.courses = courses;
    }


}
