import console.ReadFromConsole;
import report.Report;
import student.AQE;
import student.Developer;
import student.Student;

import java.text.ParseException;

public class MainClass {
    //    TODO добавить класс с курсами

    public static void main(String[] args) throws ParseException {
       String dateOfLaunch = ReadFromConsole.getDateOfLaunch();
        //        прочитали из консоли тип отчета
        String typeReport = ReadFromConsole.getTypeOfReport();
        //        прочитали из консоли время отчета
         String timeReport = ReadFromConsole.getTimeReport();
        Report report = new Report();
        Student ivanov = new Developer("Ivanov Ivan", "student.Developer", "01.06.2020");
        Student sidorov = new AQE("Sidorov Ivan", "student.AQE", "01.06.2020");
//        вывели отчет
        report.reportToConsole(ivanov, dateOfLaunch, typeReport, timeReport);
        report.reportToConsole(sidorov, dateOfLaunch, typeReport, timeReport);
    }
}
