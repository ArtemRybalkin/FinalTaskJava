package student;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Course {
    @Getter
    String name;
    @Getter
    int duration;
}
