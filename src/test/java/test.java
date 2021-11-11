import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class test {

    @Test
   public void checkDaysBetween() {
      int days = Report.getDaysBetween(MainClass.sidorov, "06.06.2020");
        Assert.assertTrue(days == 5);
    }
    @Test
    public void checkEndDate() {
        String endDate = Report.endDateCourse(MainClass.ivanov);
        Assert.assertTrue(endDate.equals("08.06.2020"));
    }

}
