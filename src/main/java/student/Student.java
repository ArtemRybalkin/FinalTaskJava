package student;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.Getter;

import java.util.List;

public abstract class Student {

    private final String name;
    private final String CURRICULUM;
    private final String startDate;

    private List<String> courseNames;

    private List<Integer> coursesDuration;

    public String getName() {
        return name;
    }

    public String getCurr() {
        return CURRICULUM;
    }

    public String getStartDate() {
        return startDate;
    }


    public abstract int getDurAllCourses();


    public List<String> getCourseNames() {
        return courseNames;
    }


    public List<Integer> getCourseDuration() {
        return coursesDuration;
    }

    public Student(String name, String CURRICULUM, String startDate, List courseNames, List coursesDuration) {
        this.name = name;
        this.CURRICULUM = CURRICULUM;
        this.startDate = startDate;
        this.courseNames = courseNames;
        this.coursesDuration = coursesDuration;

    }


}
