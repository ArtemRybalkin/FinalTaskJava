package console;
import report.TypeOfReport;
import java.util.Scanner;

public class ReadFromConsole {
    private static final Scanner in = new Scanner(System.in);
    private static final  String PATTERN_DATE = "(0?[1-9]|[12][0-9]|3[01])\\.(0?[1-9]|1[012])\\.((20)\\d\\d)";
    private static final  String PATTERN_TIME = "(1?[0-8])";

    public static String getDateOfLaunch() {
        String dateOfLaunchFromConsole = "";
        // считываем дату с консоли
        do {
            System.out.println("Please insert the date of launch in format dd.mm.yyyy");
            dateOfLaunchFromConsole = in.nextLine();
        } while (!dateOfLaunchFromConsole.matches(PATTERN_DATE));
        return dateOfLaunchFromConsole;
    }

    public static String getTimeReport() {
        String timeFromConsole = "";
        do {
            System.out.println("Please insert time from 10 to 18");
            timeFromConsole = in.nextLine();
        } while (!timeFromConsole.matches(PATTERN_TIME));
        return timeFromConsole;
    }

    public static String getTypeOfReport() {
        String typeOfReport = "";
        //считываем тип отчета с консоли
        System.out.println("Please insert the type of report.Report, short (empty or 0) or full(write any text)");
        String textFromConsole = in.nextLine();
        return getType(textFromConsole);
    }

    public static String getType(String textFromConsole) {
        String typeOfReport;
        if (textFromConsole.isEmpty() || textFromConsole.equals("0")) {
            typeOfReport = TypeOfReport.SHORT_REPORT.getTypeOfReport();
        } else typeOfReport = TypeOfReport.FULL_REPORT.getTypeOfReport();
        return typeOfReport;
    }
}