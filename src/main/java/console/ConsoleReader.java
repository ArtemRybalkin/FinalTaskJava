package console;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import report.TypeOfReport;
import java.util.Scanner;


public class ConsoleReader {
    private final Scanner in = new Scanner(System.in);
    private static final String PATTERN_DATE = "(0?[1-9]|[12][0-9]|3[01])\\.(0?[1-9]|1[012])\\.((20)\\d\\d)";
    private static final String PATTERN_TIME = "(1?[0-8])";
    private final Logger logger = LogManager.getLogger();
    public String getDateOfLaunch() {
        String dateOfLaunchFromConsole = "";
        // считываем дату с консоли
        do {
            logger.info("Please insert the date of launch in format dd.mm.yyyy");
            dateOfLaunchFromConsole = in.nextLine();
        } while (!dateOfLaunchFromConsole.matches(PATTERN_DATE));
        return dateOfLaunchFromConsole;
    }

    public String getTimeReport() {
        String timeFromConsole = "";
        do {
            logger.info("Please insert time from 10 to 18");
            timeFromConsole = in.nextLine();
        } while (!timeFromConsole.matches(PATTERN_TIME));
        return timeFromConsole;
    }

    public String getTypeOfReport() {
        //считываем тип отчета с консоли
        logger.info("Please insert the type of report.Report, short (empty or 0) or full(write any text)");
        String textFromConsole = in.nextLine();
        return getType(textFromConsole);
    }

    public String getType(String textFromConsole) {
        String typeOfReport;
        if (textFromConsole.isEmpty() || textFromConsole.equals("0")) {
            typeOfReport = TypeOfReport.SHORT_REPORT.getType();
        } else typeOfReport = TypeOfReport.FULL_REPORT.getType();
        return typeOfReport;
    }
}