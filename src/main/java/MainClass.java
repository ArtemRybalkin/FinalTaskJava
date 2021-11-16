import console.ReadFromConsole;
import report.Report;
import student.AQE;
import student.Developer;
import student.Student;

import java.text.ParseException;

public class MainClass {
    //    TODO
    //    создали первого персонажа
    public static Student ivanov = new Developer("Ivanov Ivan", "student.Developer", "01.06.2020");
    //   создали второго персонажа
    public static Student sidorov = new AQE("Sidorov Ivan", "student.AQE", "01.06.2020");
    //        прочитали из консоли дату
    private static final String dateOfLaunch = ReadFromConsole.getDateOfLaunch();
    //        прочитали из консоли тип отчета
    private static final String typeReport = ReadFromConsole.getTypeOfReport();
    //        прочитали из консоли время отчета
    private static final String timeReport = ReadFromConsole.getTimeReport();

    public static void main(String[] args) throws ParseException {
        Report report = new Report();
//        вывели отчет
        report.reportToConsole(ivanov, dateOfLaunch, typeReport, timeReport);
        report.reportToConsole(sidorov, dateOfLaunch, typeReport, timeReport);
    }
}
