import java.util.Scanner;

public class ReadFromConsole {

    static String dateOfLaunchToReport = "";
//
    public static String getDateOfLaunch() {
        final Scanner in = new Scanner(System.in);
//        добавить обработку, если введут дату дальше сегодня
        final String patternDate = "(0?[1-9]|[12][0-9]|3[01])\\.(0?[1-9]|1[012])\\.((20)\\d\\d)";
        String dateOfLaunchFromConsole = "";
        // считываем дату с консоли
        do {
            System.out.println("Please insert the date of launch in format dd.mm.yyyy");
            dateOfLaunchFromConsole = in.nextLine();
        } while (!dateOfLaunchFromConsole.matches(patternDate));
        dateOfLaunchToReport = dateOfLaunchFromConsole;
        return dateOfLaunchToReport;
    }

    static String timeReport = "";

    public static String getTimeReport() {
        final Scanner in = new Scanner(System.in);
        final String patternTime = "(1?[0-8])";
        String timeFromConsole = "";
        do {
            System.out.println("Please insert time from 10 to 18");
            timeFromConsole = in.nextLine();
        } while (!timeFromConsole.matches(patternTime));
        timeReport = timeFromConsole;
        return timeReport;
    }

    static String typeOfReport = "";
    public static String getTypeOfReport() {
        final Scanner in = new Scanner(System.in);
        //считываем тип отчета с консоли
        System.out.println("Please insert the type of Report, short (empty or 0) or full(write any text)");
        String textFromConsole = in.nextLine();
        if (textFromConsole.isEmpty() | textFromConsole.equals("0")) {
            typeOfReport = "short";
        } else typeOfReport = "full";
        return typeOfReport;
    }
}
