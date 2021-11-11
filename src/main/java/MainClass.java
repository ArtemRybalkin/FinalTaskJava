import org.joda.time.DateTime;

import java.text.ParseException;
import java.util.Date;

public class MainClass {

   static Student ivanov = new Developer(StudentIvanov.NAME.getValue(), "Java Developer", "01.06.2020", Developer.Courses );
   static Student sidorov = new AQE("Sidorov Ivan", "AQE", "01.06.2020", AQE.Courses);

    public static void main(String[] args) throws ParseException {
//        прочитать из консоли дату
        ReadFromConsole.getDateOfLaunch();
//        Report.convertLaunchDate();
//        считываем время отчета
        ReadFromConsole.getTimeReport();
//        прочитать из консоли тип отчета
       ReadFromConsole.getTypeOfReport();
//        вывести отчет
        Report.reportToConsole(ivanov);
        Report.reportToConsole(sidorov);



    }

}
