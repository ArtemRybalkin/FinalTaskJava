import report.*;
import models.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class MainClass {

    public static void main(String[] args) {

        Report report = new Report();
        Student ivanov = new Developer("Ivanov Ivan", "Developer",
                LocalDateTime.of(LocalDate.of(2018, 6, 1), LocalTime.of(10, 0)));
        Student sidorov = new AQE("Sidorov Ivan", "AQE",
                LocalDateTime.of(LocalDate.of(2020, 6, 1), LocalTime.of(10, 0)));
        report.reportToConsole(ivanov);
        report.reportToConsole(sidorov);
    }
}
