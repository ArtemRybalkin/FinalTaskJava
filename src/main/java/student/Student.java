package student;

import lombok.Getter;

import java.util.List;

public abstract class Student {
    @Getter
    private final String name;
    @Getter
    private final String curriculum;
    @Getter
    private final String startDate;
    @Getter
    private final List<String> courseNames;
    @Getter
    private final List<Integer> coursesDuration;

    public int getDurAllCourses() {
        int sum = 0;
        for (Integer courseDuration : coursesDuration) {
            sum += courseDuration;
        }
        return sum;
    }

    public void setCourseNames(String courseName) {
        courseNames.add(courseName);
    }

    public void setCoursesDuration(int courseDuration) {
        coursesDuration.add(courseDuration);
    }

    public Student(String name, String CURRICULUM, String startDate, List<String> courseNames, List<Integer> coursesDuration) {
        this.name = name;
        this.curriculum = CURRICULUM;
        this.startDate = startDate;
        this.courseNames = courseNames;
        this.coursesDuration = coursesDuration;
    }


}
