import java.text.ParseException;
import java.util.Scanner;

public class MainClass {
    //    TODO сделать переменные приватными
//    TODO
    static final Scanner in = new Scanner(System.in);
    //    создали первого персонажа
    static Student ivanov = new Developer("Ivanov Ivan", "Developer", "01.06.2020", Developer.courses);
    //   создали второго персонажа
    static Student sidorov = new AQE(Sidorov.NAME.getValue(), Sidorov.CURR.getValue(), Sidorov.START_DATE.getValue(), AQE.courses);
    //        прочитали из консоли дату
    private static String dateOfLaunch = ReadFromConsole.getDateOfLaunch(in);
    //        прочитали из консоли тип отчета
    static String typeReport = ReadFromConsole.getTypeOfReport(in);
    //        прочитали из консоли время отчета
    static String timeReport = ReadFromConsole.getTimeReport(in);

    public static void main(String[] args) throws ParseException {
        Report report = new Report();
//        вывели отчет
        report.reportToConsole(ivanov, dateOfLaunch, typeReport, timeReport);
        report.reportToConsole(sidorov, dateOfLaunch, typeReport, timeReport);

    }
}
