import java.text.ParseException;
import java.util.Scanner;

public class MainClass {
    static Scanner in = new Scanner(System.in);
   static Student ivanov = new Developer(StudentIvanov.NAME.getValue(), StudentIvanov.CURR.getValue(),
           StudentIvanov.START_DATE.getValue(), Developer.Courses );
   static Student sidorov = new AQE(StudentSidorov.NAME.getValue(), StudentSidorov.CURR.getValue(),
           StudentSidorov.START_DATE.getValue(), AQE.Courses);
    //        прочитать из консоли дату
    static String dateOfLaunch = ReadFromConsole.getDateOfLaunch(in);
    //        прочитать из консоли тип отчета
    static String typeReport = ReadFromConsole.getTypeOfReport(in);
    //        считываем время отчета
    static String timeReport = ReadFromConsole.getTimeReport(in);
    public static void main(String[] args) throws ParseException {

//        вывести отчет
        Report.reportToConsole(ivanov, dateOfLaunch, typeReport, timeReport);
        Report.reportToConsole(sidorov, dateOfLaunch, typeReport, timeReport);

    }
}
