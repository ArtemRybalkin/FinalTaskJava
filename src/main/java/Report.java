import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Report {
    public static void reportToConsole(Student student, String dateOfLaunchToReport, String typeReport, String timeReport) throws ParseException {
        int daysBetween = getDaysBetween(student, dateOfLaunchToReport);
        int numbOfWeekends = (daysBetween / 7) * 2;
        if (daysBetween > 5) daysBetween -= numbOfWeekends;      // с учётом рабочей недели
//        int daysPass = daysBetween - student.getDurCourses();
        int hoursFromConsole = Integer.parseInt(timeReport);
        int allHours = (daysBetween * 8) + (hoursFromConsole - 10);
        int hoursPass = (student.getDurCourses() - allHours);
        String daysPassNot = hoursPass / 8 + " days " + hoursPass % 8 + " hours";
        String daysPass = (-hoursPass / 8) + " days " + (-hoursPass % 8) + " hours";
        String formatedDete = convertLaunchDate(dateOfLaunchToReport);
        Object[] keys = student.getCourses().keySet().toArray();
        String key0 = (String) keys[0];
        String key1 = (String) keys[1];
        String key2 = (String) keys[2];
        Object[] values = student.getCourses().values().toArray();
        int value0 = (Integer) values[0];
        int value1 = (Integer) values[1];
        int value2 = (Integer) values[2];
        String[] status = new String[3];

        if (value0 <= allHours) {
            status[0] = "complete";
        } else status[0] = "not complete. Left " + (value0 - allHours) + " hours";
        if ((value1 + value0) <= allHours) {
            status[1] = "complete";
        } else status[1] = "not complete. Left " + ((value0 + value1) - allHours) + " hours";
        if ((value2 + value0 + value1) <= allHours) {
            status[2] = "complete";
        } else status[2] = "not complete. Left " + ((value0 + value1 + value2) - allHours) + " hours";

        if (typeReport.equals("short")) {
            System.out.println("(Generating report date - " + formatedDete +
                    ", " + hoursFromConsole + ":00" + "):");
            if (hoursPass <= 0) {
                System.out.println(student.getName() + " " + student.getCurr() + " - Training completed. " + daysPass +
                        " have passed since the end.");
            } else {
                System.out.println(student.getName() + " " + student.getCurr() + " - Training is not finished. " +
                        daysPassNot + " are left until the end.");
            }
        } else {
            if (hoursPass <= 0) {
                System.out.println(student.getName());
                System.out.println("working time (from 10 to 18): " + student.getDurCourses() + " hours");
                System.out.println(key0 + "  " + value0 + " hours " + " Status: " + status[0]);
                System.out.println(key1 + "  " + value1 + " hours " + " Status: " + status[1]);
                System.out.println(key2 + "  " + value2 + " hours " + " Status: " + status[2]);
                System.out.println("start date: " + student.getStartDate());
                System.out.println("end date: " + endDateCourse(student, numbOfWeekends));
                System.out.println("Training completed. " + daysPass + " days have passed since the end.");
            } else {
                System.out.println(student.getName());
                System.out.println("working time (from 10 to 18): " + allHours + " hours");
                System.out.println(key0 + "  " + value0 + " hours " + " Status: " + status[0]);
                System.out.println(key1 + "  " + value1 + " hours " + " Status: " + status[1]);
                System.out.println(key2 + "  " + value2 + " hours " + " Status: " + status[2]);
                System.out.println("start date: " + student.getStartDate());
                System.out.println("end date: Not complete ");
                System.out.println("Training is not completed. " + daysPassNot + " are left until the end.");
            }
        }
    }


    static String convertLaunchDate(String dateOfLaunchToReport) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat formatter2 = new SimpleDateFormat("dd MMMM yyyy, EEEE");
        Date date = formatter.parse(dateOfLaunchToReport);
        String formatedDete = formatter2.format(date);
        return formatedDete;
    }


    static int getDaysBetween(Student student, String dateOfLaunch) {
        DateTimeFormatter fmt2 = DateTimeFormat.forPattern("dd.MM.yyyy");
        DateTime dt3 = fmt2.parseDateTime(student.getStartDate());
        DateTime dt2 = fmt2.parseDateTime(dateOfLaunch);
        dt2.getDayOfWeek();
        int daysBetween = Days.daysBetween(dt3, dt2).getDays();  //вычисляем сколько дней прошло с момента старта
        return daysBetween;
    }

    static String endDateCourse(Student student, int numbOfWeekends) {
        DateTimeFormatter fmt2 = DateTimeFormat.forPattern("dd.MM.yyyy");
        DateTime dt3 = fmt2.parseDateTime(student.getStartDate());
        DateTime endDateCourse = (dt3.plusDays(student.getDurCourses() / 8 + numbOfWeekends));
        String dt4 = endDateCourse.toString(fmt2);
        return dt4;
    }


}
