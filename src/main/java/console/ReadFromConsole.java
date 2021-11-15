package console;

import report.TypeOfReport;

import java.util.Scanner;
import java.util.logging.Logger;

public class ReadFromConsole {
   private static final Scanner in = new Scanner(System.in);
   private final static String patternDate = "(0?[1-9]|[12][0-9]|3[01])\\.(0?[1-9]|1[012])\\.((20)\\d\\d)";
   private final static String patternTime = "(1?[0-8])";
  static Logger logger =  Logger.getLogger(ReadFromConsole.class.getName());

    public static String getDateOfLaunch() {

        String dateOfLaunchToReport = "";
//        добавить обработку, если введут дату дальше сегодня

        String dateOfLaunchFromConsole = "";
        // считываем дату с консоли
        do {
//            System.out.println("Please insert the date of launch in format dd.mm.yyyy");
            logger.info("Please insert the date of launch in format dd.mm.yyyy");
            dateOfLaunchFromConsole = in.nextLine();
        } while (!dateOfLaunchFromConsole.matches(patternDate));
        dateOfLaunchToReport = dateOfLaunchFromConsole;
        return dateOfLaunchToReport;
    }

    public static String getTimeReport() {
        String timeReport = "";

        String timeFromConsole = "";
        do {
            System.out.println("Please insert time from 10 to 18");
            timeFromConsole = in.nextLine();
        } while (!timeFromConsole.matches(patternTime));
        timeReport = timeFromConsole;
        return timeReport;
    }

    public static String getTypeOfReport() {
        String typeOfReport = "";
        //считываем тип отчета с консоли
        System.out.println("Please insert the type of report.Report, short (empty or 0) or full(write any text)");
        String textFromConsole = in.nextLine();
        if (textFromConsole.isEmpty() | textFromConsole.equals("0")) {
            typeOfReport = TypeOfReport.shortReport.getTypeOfReport();
        } else typeOfReport = TypeOfReport.fullReport.getTypeOfReport();
        return typeOfReport;
    }
}