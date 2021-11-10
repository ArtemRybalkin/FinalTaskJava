import java.util.Scanner;

public class ReadFromConsole {
    static final Scanner in = new Scanner(System.in);

//
    public static String getDateFromConsole() {
        String dateOfLaunchToReport = "";
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

    public static String getTypeOfReportFromConsole() {
        //считываем тип отчета с консоли
        System.out.println("Please insert the type of Report, short or full");
        String typeOfReport = "";
        String textFromConsole = in.nextLine();
        if (textFromConsole.isEmpty() | textFromConsole.equals("0")) {
            typeOfReport = "short";
        } else typeOfReport = "full";
        in.close();
        return typeOfReport;
    }
}
