package console;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import report.TypeOfReport;

import java.util.Scanner;

public class ConsoleReader {

    private final Scanner in = new Scanner(System.in);
    private final Logger logger = LogManager.getLogger();
    public String getDateOfLaunch() {
        logger.info("Please insert the date and time of launch in the format dd.MM.yyyy HH");
        return in.nextLine();
    }

    public TypeOfReport getTypeOfReport() {
        logger.info("Please insert the type of Report, short (empty or 0) or full(write any text)");
        String textFromConsole = in.nextLine();
        return TypeOfReport.getType(textFromConsole);
    }
}