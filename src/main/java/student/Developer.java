package student;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

public class Developer extends Student {
    @Getter
    List<Course> courseList = new ArrayList<>();
    public Developer(String name, String curriculum, String startDate) {
        super(name, curriculum, startDate);
        courseList.add(new Course("Java", 16));
        courseList.add(new Course("JDBC", 24));
        courseList.add(new Course("Spring", 16));
    }
}
