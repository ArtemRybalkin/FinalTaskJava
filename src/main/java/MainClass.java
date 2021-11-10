import java.text.ParseException;

public class MainClass extends Report {



    public static void main(String[] args) throws ParseException {
        MainClass m = new MainClass();

       String str =  ReadFromConsole.getTypeOfReportFromConsole();

        if (str.equals("short")) {
            m.shortReport(daysBetween, durCourseIvanov, durCourseSidorov);
//
        } else {
//        если тип репорта full
            m.fullReport();
        }



    }


}
