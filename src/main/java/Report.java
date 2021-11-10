import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Report implements TypeOfReport {
   private final String pattern = "dd MMMM yyyy, E, hh:mm";
   private final SimpleDateFormat fmt = new SimpleDateFormat(pattern);
//   private String today = fmt.format(new Date());
    int durForReportIvanov = daysBetween - durCourseIvanov;

    int durForReportSidorov = daysBetween - durCourseSidorov;
    String getTextShortReportCompl (int durForReport) {
        String textShortReportCompl = "Training completed." + durForReport + " days have passed since the end.";
        return textShortReportCompl ;
    }
    String getTextShortReportNoCompl (int durForReport) {
        String textShortReportNoCompl = "Training is not finished. " + (durForReport) + " days are left until the end.";
        return  textShortReportNoCompl;
    }

    String student1Name = StudentIvanov.NAME.getValue();
    String student1Curriculum = StudentIvanov.CURRICULUM.getValue();
    String student1Course1 = StudentIvanov.JDBC.getValue();
    String student1Course2 = StudentIvanov.Spring.getValue();
    String student1Course3 = StudentIvanov.JAVA.getValue();
    String student2Name = StudentSidorov.NAME.getValue();
    String student2Curriculum = StudentSidorov.CURRICULUM.getValue();
    String student2Course1 = StudentSidorov.TestDesign.getValue();
    String student2Course2 = StudentSidorov.PageObject.getValue();
    String student2Course3 = StudentSidorov.Selenium.getValue();

    @Override
    public void shortReport(int daysBetween, int durCourseIvanov, int durCourseSidorov) {
        System.out.println("Short (Generating report date " + dt2 + " ):");

        if (daysBetween > durCourseIvanov) {
            System.out.println(student1Name + " (" + student1Curriculum + ") " + "- " + getTextShortReportCompl(durForReportIvanov));

        } else {
            System.out.println(student1Name + " (" + student1Curriculum + ") " + "- " + getTextShortReportNoCompl(durForReportIvanov));
        }
        if (daysBetween > durCourseSidorov) {
            System.out.println(student2Name + " (" + student2Curriculum + ") " + "- " + getTextShortReportCompl(durForReportSidorov));

        } else {
            System.out.println(student2Name + " (" + student2Curriculum + ") " + "- " + getTextShortReportNoCompl(durForReportSidorov));
        }
    }

    @Override
    public void fullReport() {
        System.out.println(student1Name);
        System.out.println("working time (from 10 to 18): " + daysBetween + " days");
        System.out.println(student1Curriculum);
        System.out.println("Course #1 : " + StudentIvanov.JAVA + " program duration: " + student1Course1 + "hours");
        System.out.println("Course #2 : " + StudentIvanov.Spring + " program duration: " + student1Course2 + "hours");
        System.out.println("Course #3 : " + StudentIvanov.JDBC + " program duration: " + student1Course3 + "hours");
        System.out.println("program duration: " + durCourseIvanov + "hours");
        System.out.println("start date: " + StudentIvanov.START_DATE.getValue());
        System.out.println("end date: " + endDateCourseIvanov);
        if (daysBetween > durCourseIvanov) {
            System.out.println(getTextShortReportCompl(durForReportIvanov));

        } else {
            System.out.println(getTextShortReportNoCompl(durForReportIvanov));
        }
    }

static String dateOfLaunchToReport1 = ReadFromConsole.getDateFromConsole();
    static DateTimeFormatter fmt2 = DateTimeFormat.forPattern("dd.MM.yyyy");
    static DateTime dt3 = fmt2.parseDateTime(StudentIvanov.START_DATE.getValue());
    static DateTime dt2 = fmt2.parseDateTime(dateOfLaunchToReport1);
    static int  daysBetween = getDaysBetween();
    private static int getDaysBetween() {
        int daysBetween = Days.daysBetween(dt3, dt2).getDays();  //вычисляем сколько дней прошло с момента старта
//        System.out.println(daysBetween);
//        System.out.println(dt2);
//        System.out.println(dt3);
        return daysBetween;
    }
    String endDateCourseIvanov = fmt.format(dt3.plusDays(durCourseIvanov).toDate());

        static int durCourseIvanov =  getDurCourse("ivanov");

        static int durCourseSidorov =  getDurCourse("sidorov");
    public static int getDurCourse(String student) {
        //        длительность курса в днях
        if (student.equals("ivanov")) {
            int durCourseJava = Integer.parseInt(StudentIvanov.JAVA.getValue());
            int durCourseJDBC = Integer.parseInt(StudentIvanov.JDBC.getValue());
            int durCourseSpring = Integer.parseInt(StudentIvanov.Spring.getValue());
            int durCourDays = (durCourseJava + durCourseJDBC + durCourseSpring) / 8;
            int cdiHours = (durCourseJava + durCourseJDBC + durCourseSpring) % 8;
//            System.out.println(durCourDays);
            return durCourDays;
        } else {
            int durCoursePO = Integer.parseInt(StudentSidorov.PageObject.getValue());
            int durCourseTD = Integer.parseInt(StudentSidorov.TestDesign.getValue());
            int durCourseSe = Integer.parseInt(StudentSidorov.Selenium.getValue());
            int durCourDays = (durCoursePO + durCourseTD + durCourseSe) / 8;
            int cdsHours = (durCoursePO + durCourseTD + durCourseSe) % 8;
            return durCourDays;
        }
    }


}
