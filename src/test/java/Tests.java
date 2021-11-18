import console.ConsoleReader;
import org.junit.Assert;
import org.junit.Test;
import report.Report;
import report.TypeOfReport;
import models.AQE;
import models.Developer;
import models.Student;

public class Tests {

    private final Student testStudentDeveloper = new Developer("Petrov Vanya", "Developer", "01.06.2020");
    private final Student testStudentAQE = new AQE("Petrenko Petro", "AQE", "01.06.2020");
    private final ConsoleReader consoleReader = new ConsoleReader();
    private final Report report = new Report();

    @Test
    public void checkStudentName(){
        String name = testStudentDeveloper.getName();
        Assert.assertEquals("Petrov Vanya", name);
    }
    @Test
    public void checkStudentCurriculum(){
        String curriculum = testStudentDeveloper.getCurriculum();
        Assert.assertEquals("Developer", curriculum);
    }
    @Test
    public void checkStudentStartDate(){
        String startDate = testStudentDeveloper.getStartDate();
        Assert.assertEquals("01.06.2020", startDate);
    }
    @Test
    public void checkDaysBetweenDeveloper() {
        int days = report.getDaysBetweenStartAndReport(testStudentDeveloper, "06.06.2020");
        Assert.assertEquals(5, days);
    }
    @Test
    public void checkDaysBetweenAQE() {
        int days = report.getDaysBetweenStartAndReport(testStudentAQE, "08.06.2020");
        Assert.assertEquals(7, days);
    }
    @Test
    public void checkEndDate() {
        String endDate = report.endDateCourse(testStudentDeveloper, 0);
        Assert.assertEquals("08.06.2020", endDate);
    }
    @Test
    public void checkStatus() {
       String str = report.getStatus(16, testStudentDeveloper).get(0);
        Assert.assertEquals("complete", str);
    }
    @Test
    public void checkTypeReportShort() {
        String str = consoleReader.getType("");
        Assert.assertEquals(TypeOfReport.SHORT_REPORT.getType(), str);
    }
    @Test
    public void checkTypeReportFull() {
        String str = consoleReader.getType(" ");
        Assert.assertEquals(TypeOfReport.FULL_REPORT.getType(), str);
    }
    @Test
    public void checkDurAllCoursesDeveloper() {
        int sum = report.getSumDurationAllCourses(testStudentDeveloper);
        Assert.assertEquals(56, sum);
    }
    @Test
    public void checkDurAllCoursesAQE() {
        int sum = report.getSumDurationAllCourses(testStudentAQE);
        Assert.assertEquals(42, sum);
    }
}
