
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import report.PrepareDates;
import report.Report;
import report.TypeOfReport;
import models.AQE;
import models.Developer;
import models.Student;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class Tests {

    private final Student testStudentDeveloper = new Developer("Petrov Vanya", "Developer", LocalDateTime.of(LocalDate.of(2020, 6, 1), LocalTime.of(10, 0)));
    private final Student testStudentAQE = new AQE("Petrenko Petro", "AQE", LocalDateTime.of(LocalDate.of(2020, 6, 1), LocalTime.of(10, 0)));
    private final PrepareDates prepare = new PrepareDates();
    private final Report report = new Report();
    private final LocalDateTime endDate = LocalDateTime.of(LocalDate.of(2020, 6, 10), LocalTime.of(10, 0));
    private final LocalDate endDateCourseDeveloper = LocalDate.of(2020, 6, 10);
    private final int workedHours = prepare.getWorkedHours(testStudentDeveloper.getStartDate(), endDate);

    @Test
    void checkWorkedHours() {
        Assertions.assertEquals(56, workedHours);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "0"})
    void checkShortReport(String arg) {
        Assertions.assertEquals(TypeOfReport.SHORT_REPORT, TypeOfReport.getType(arg));
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "t", "2"})
    void checkFullReport(String arg) {
        Assertions.assertEquals(TypeOfReport.FULL_REPORT, TypeOfReport.getType(arg));
    }

    @Test
    void checkEndDateCourse() {
        LocalDate endDateCourse = report.getEndDateCourse(testStudentDeveloper.getStartDate(), workedHours / 8);
        Assertions.assertEquals(endDateCourseDeveloper, endDateCourse);
    }

    @Test
    void checkSumDurationAllCourses() {
        int sum = testStudentAQE.getSumDurationAllCourses();
        Assertions.assertEquals(42, sum);
    }

    @Test
    void checkSize() {
        IndexOutOfBoundsException thrown = Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
            testStudentDeveloper.getCourseList().get(5);
        });

        Assertions.assertEquals("Index: 5, Size: 3", thrown.getMessage());
    }
//    TODO add negative tests, parametr


}
