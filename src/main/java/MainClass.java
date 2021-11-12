import java.text.ParseException;
import java.util.Scanner;

public class MainClass {
    static Scanner in = new Scanner(System.in);
//    создали первого персонажа
   static Student ivanov = new Developer(Ivanov.NAME.getValue(), Ivanov.CURR.getValue(),
           Ivanov.START_DATE.getValue(), Developer.Courses );
//   создали второго персонажа
   static Student sidorov = new AQE(Sidorov.NAME.getValue(), Sidorov.CURR.getValue(),
           Sidorov.START_DATE.getValue(), AQE.Courses);
    //        прочитали из консоли дату
    static String dateOfLaunch = ReadFromConsole.getDateOfLaunch(in);
    //        прочитали из консоли тип отчета
    static String typeReport = ReadFromConsole.getTypeOfReport(in);
    //        прочитали из консоли время отчета
    static String timeReport = ReadFromConsole.getTimeReport(in);
    public static void main(String[] args) throws ParseException {

//        вывели отчет
        Report.reportToConsole(ivanov, dateOfLaunch, typeReport, timeReport);
        Report.reportToConsole(sidorov, dateOfLaunch, typeReport, timeReport);

    }
}
