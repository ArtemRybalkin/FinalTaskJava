import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Scanner;

public class test {
    Scanner in = new Scanner(System.in);


    @Test
   public void checkDaysBetween() {
      int days = Report.getDaysBetween(MainClass.ivanov, "06.06.2020");
        Assert.assertTrue(days == 5);
    }
    @Test
    public void checkEndDate() {
        String endDate = Report.endDateCourse(MainClass.ivanov, 0);
        Assert.assertEquals("08.06.2020", endDate);
    }

    @Test
    public void checkTypeReportShort () {

        Assert.assertEquals("short", ReadFromConsole.getTypeOfReport());
    }
}
