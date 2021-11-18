import console.*;
import report.Report;
import models.AQE;
import models.Developer;
import models.Student;

import java.text.ParseException;

public class MainClass {

    public static void main(String[] args) throws ParseException {
        ConsoleReader consoleReader = new ConsoleReader();
        Report report = new Report();
        Student ivanov = new Developer("Ivanov Ivan", "Developer", "01.06.2020");
        Student sidorov = new AQE("Sidorov Ivan", "AQE", "01.06.2020");
        String dateOfLaunch = consoleReader.getDateOfLaunch();
        String timeReport = consoleReader.getTimeReport();
        String typeReport = consoleReader.getTypeOfReport();
        report.reportToConsole(ivanov, dateOfLaunch, typeReport, timeReport);
        report.reportToConsole(sidorov, dateOfLaunch, typeReport, timeReport);
    }
}
