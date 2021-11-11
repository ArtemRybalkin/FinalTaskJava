import java.util.Map;

public abstract class Student {

    private String name;
    private String CURRICULUM;
    private String startDate;
    private Map Courses;

    public String getName() {
        return name;
    }
    public String getCurr() {
        return CURRICULUM;
    }
    public String getStartDate() {
        return startDate;
    }
    public Map getCourses() {
        return Courses;
    }
      public abstract int getDurCourses();

    public Student (String name, String CURRICULUM, String startDate, Map courses ) {
        this.name = name;
        this.CURRICULUM = CURRICULUM;
        this.startDate = startDate;
        this.Courses = courses;
    }



}
