import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Report {
    private List<Integer> courseDurationList;
    private List<String> courseNameList;
    private String formatDate;
    private int hoursFromConsole;
    private List<String> fullStatusList;
    private int allHours;

    public void reportToConsole(Student student, String dateOfLaunchToReport, String typeReport, String timeReport) throws ParseException {
        formatDate = convertLaunchDate(dateOfLaunchToReport);
        int daysBetween = getDaysBetween(student, dateOfLaunchToReport);
        int numbOfWeekends = (daysBetween / 7) * 2;
        if (daysBetween > 5) daysBetween -= numbOfWeekends;      // с учётом рабочей недели
        hoursFromConsole = Integer.parseInt(timeReport);
        allHours = (daysBetween * 8) + (hoursFromConsole - 10);
        int hoursPass = (student.getDurAllCourses() - allHours);
        courseNameList = student.getCourseNames();
        courseDurationList = student.getCourseDuration();
        getStatus(allHours);

        if (typeReport.equals("Short")) {
            shortReport(student, hoursPass);
        } else {   //если тип отчета full
            fullReport(student, hoursPass, numbOfWeekends);
        }
    }

    private void shortReport(Student student, int hoursPass) {
        System.out.println("(Generating report date - " + formatDate + ", " + hoursFromConsole + ":00" + "):");
        if (hoursPass <= 0) {
            System.out.println(student.getName() + " " + student.getCurr() + " - Training completed. " + getDaysPass(hoursPass) +
                    " have passed since the end.");
        } else {
            System.out.println(student.getName() + " " + student.getCurr() + " - Training is not finished. " +
                    getDaysPassNot(hoursPass) + " are left until the end.");
        }
    }

    private String getDaysPass(int hoursPass) {
        return (-hoursPass / 8) + " days " + (-hoursPass % 8) + " hours";
    }

    private String getDaysPassNot(int hoursPass) {
        return hoursPass / 8 + " days " + hoursPass % 8 + " hours";
    }

    private void fullReport(Student student, int hoursPass, int numbOfWeekends) {
        System.out.println(student.getName());
        if (hoursPass <= 0) {
            System.out.println("working time (from 10 to 18): " + student.getDurAllCourses() + " hours");
            printStatus();
            System.out.println("start date: " + student.getStartDate());
            System.out.println("end date: " + endDateCourse(student, numbOfWeekends));
            System.out.println("Training completed. " + getDaysPass(hoursPass) + " days have passed since the end.");
        } else {
            System.out.println("working time (from 10 to 18): " + allHours + " hours");
            printStatus();
            System.out.println("start date: " + student.getStartDate());
            System.out.println("end date: Not complete ");
            System.out.println("Training is not completed. " + getDaysPassNot(hoursPass) + " are left until the end.");
        }
    }

    private void getStatus(int allHours) {
        fullStatusList = new ArrayList<>();
        int sum = 0;
        for (Integer integer : courseDurationList) {
            if (integer <= allHours - sum) {
                fullStatusList.add(String.valueOf(Status.COMPLETE.getStatus()));
            } else
                fullStatusList.add(Status.NOT_COMPLETE.getStatus() + (integer - (allHours - sum)) + " hours left");
            sum += integer;
        }
    }

    private void printStatus() {
        for (int i = 0; i < courseNameList.size(); i++) {
            System.out.printf("%s %s hours " + " Status: " + fullStatusList.get(i) + "\n", courseNameList.get(i), courseDurationList.get(i));
        }
    }

    static String convertLaunchDate(String dateOfLaunchToReport) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat formatter2 = new SimpleDateFormat("dd MMMM yyyy, EEEE");
        Date date = formatter.parse(dateOfLaunchToReport);
        return formatter2.format(date);
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
        DateTime endDateCourse = (dt3.plusDays(student.getDurAllCourses() / 8 + numbOfWeekends));
        String dt4 = endDateCourse.toString(fmt2);
        return dt4;
    }

}
