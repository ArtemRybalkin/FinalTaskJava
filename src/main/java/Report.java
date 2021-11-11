import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Report {
    public static void reportToConsole(Student student) {
        int daysBetween = getDaysBetween(student, ReadFromConsole.dateOfLaunchToReport);
        int daysPass = daysBetween - student.getDurCourses();
        Object[] keys = student.getCourses().keySet().toArray();
        String key0 = (String) keys[0];
        String key1 = (String) keys[1];
        String key2 = (String) keys[2];
        Object[] values = student.getCourses().values().toArray();
        int value0 = (Integer) values[0];
        int value1 = (Integer) values[1];
        int value2 = (Integer) values[2];
        String[] status = new String[3] ;
        if (value0 <= daysBetween*8 ) {
            status[0] = "complete";
        } else status[0] = "not complete. Left " + (value0 - daysBetween*8) + " hours";
        if (value1 + value0 < (daysBetween/8) ) {
          status[1] = "complete";
        } else status[1] = "not complete. Left " + ((value0 + value1) - daysBetween*8) + " hours";
        if (value2 + value0 + value1 < (daysBetween/8) ) {
           status[2] = "complete";
        }  else status[2] = "not complete. Left " + ((value0 + value1+value2) - daysBetween*8) + " hours";

        if (ReadFromConsole.typeOfReport.equals("short")) {
            System.out.println("(Generating report date - " + ReadFromConsole.dateOfLaunchToReport + "):");
            if (daysBetween > student.getDurCourses()) {
                System.out.println(student.getName() + " " + student.getCurr() + " - Training completed. " + daysPass +
                        " days have passed since the end.");
            } else {
                System.out.println(student.getName() + " " + student.getCurr() + " - Training is not finished. " +
                        (-daysPass) + " days are left until the end.");
            }
        } else {
            if (daysBetween > student.getDurCourses()) {
                System.out.println(student.getName());
                System.out.println("working time (from 10 to 18): " + student.getDurCourses() + " days");
                System.out.println(key0 + "  " + value0 + " hours " + " Status: " + status[0]);
                System.out.println(key1 + "  " + value1 + " hours " + " Status: " + status[1]);
                System.out.println(key2 + "  " + value2 + " hours " + " Status: " + status[2]);
                System.out.println("start date: " + student.getStartDate());
                System.out.println("end date: " + endDateCourse(student));
                System.out.println("Training completed. " + daysPass + " days have passed since the end.");
            } else {
                System.out.println(student.getName());
                System.out.println("working time (from 10 to 18): " + daysBetween + " days");
                System.out.println(key0 + "  " + value0 + " hours " + " Status: " + status[0]);
                System.out.println(key1 + "  " + value1 + " hours " + " Status: " + status[1]);
                System.out.println(key2 + "  " + value2 + " hours " + " Status: " + status[2]);
                System.out.println("start date: " + student.getStartDate());
                System.out.println("end date: Not complete " );
                System.out.println("Training is not completed. " + (-daysPass) + " days are left until the end.");
            }
        }
    }

     static int getDaysBetween(Student student, String dateOfLaunch) {
        DateTimeFormatter fmt2 = DateTimeFormat.forPattern("dd.MM.yyyy");
        DateTime dt3 = fmt2.parseDateTime(student.getStartDate());
        DateTime dt2 = fmt2.parseDateTime(dateOfLaunch);
        int daysBetween = Days.daysBetween(dt3, dt2).getDays();  //вычисляем сколько дней прошло с момента старта
        return daysBetween;
    }

     static String endDateCourse(Student student) {
        DateTimeFormatter fmt2 = DateTimeFormat.forPattern("dd.MM.yyyy");
        DateTime dt3 = fmt2.parseDateTime(student.getStartDate());
        DateTime endDateCourse = (dt3.plusDays(student.getDurCourses()));
        String dt4 = endDateCourse.toString(fmt2);
        return dt4;
    }


}
