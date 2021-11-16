import console.ReadFromConsole;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import report.Report;
import student.Developer;
import student.Student;

import java.util.List;

public class Tests {

Student testStudent = new Developer("Petrov Vanya", "Developer", "01.06.2020");

    @Test
   public void checkDaysBetween() {
      int days = Report.getDaysBetween(testStudent, "06.06.2020");
        Assert.assertEquals(5,days);
    }
    @Test
    public void checkEndDate() {
        String endDate = Report.endDateCourse(testStudent, 0);
        Assert.assertEquals("08.06.2020", endDate);
    }
    @Test
    public void checkStatus() {

        List<Integer> courseDurationList = testStudent.getCoursesDuration();
        Report.getStatus(16,courseDurationList);
        String str = Report.fullStatusList.get(0);
        Assert.assertEquals( "complete" , str);

    }
    @Test
    public void checkTypeReportShort () {
      String str = ReadFromConsole.getType("");
        Assert.assertEquals("Short", str);
    }
    @Test
    public void checkTypeReportFull () {
      String str = ReadFromConsole.getType(" ");
        Assert.assertEquals("Full", str);
    }
}
