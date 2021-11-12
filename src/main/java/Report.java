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

    private List<String> fullStatusList;
    private List<Integer> courseDurationList;
    private List<String> courseNameList;


    public void reportToConsole(Student student, String dateOfLaunchToReport, String typeReport, String timeReport) throws ParseException {
        int daysBetween = getDaysBetween(student, dateOfLaunchToReport);
        int numbOfWeekends = (daysBetween / 7) * 2;
        if (daysBetween > 5) daysBetween -= numbOfWeekends;      // с учётом рабочей недели

        int hoursFromConsole = Integer.parseInt(timeReport);
        int allHours = (daysBetween * 8) + (hoursFromConsole - 10);
        int hoursPass = (student.getDurCourses() - allHours);

        String daysPassNot = hoursPass / 8 + " days " + hoursPass % 8 + " hours";
        String daysPass = (-hoursPass / 8) + " days " + (-hoursPass % 8) + " hours";
        String formatDate = convertLaunchDate(dateOfLaunchToReport);

        courseNameList = student.getCourseNames();
        courseDurationList = student.getCourseDuration();
        fullStatusList = new ArrayList<>();
        getStatus(allHours);

        if (typeReport.equals("short")) {
            System.out.println("(Generating report date - " + formatDate + ", " + hoursFromConsole + ":00" + "):");
            if (hoursPass <= 0) {
                System.out.println(student.getName() + " " + student.getCurr() + " - Training completed. " + daysPass +
                        " have passed since the end.");
            } else {
                System.out.println(student.getName() + " " + student.getCurr() + " - Training is not finished. " +
                        daysPassNot + " are left until the end.");
            }
        } else {   //если тип отчета full
            System.out.println(student.getName());
            if (hoursPass <= 0) {
                System.out.println("working time (from 10 to 18): " + student.getDurCourses() + " hours");
                printStatus();
                System.out.println("start date: " + student.getStartDate());
                System.out.println("end date: " + endDateCourse(student, numbOfWeekends));
                System.out.println("Training completed. " + daysPass + " days have passed since the end.");
            } else {
                System.out.println("working time (from 10 to 18): " + allHours + " hours");
                printStatus();
                System.out.println("start date: " + student.getStartDate());
                System.out.println("end date: Not complete ");
                System.out.println("Training is not completed. " + daysPassNot + " are left until the end.");
            }
        }
    }

    private void getStatus(int allHours) {
        if (courseDurationList.get(0) <= allHours) {
            fullStatusList.add(String.valueOf(Status.COMPLETE.getStatus()));
        } else
            fullStatusList.add(Status.NOT_COMPLETE.getStatus() + (courseDurationList.get(0) - allHours) + " hours left");
        if ((courseDurationList.get(1) + courseDurationList.get(0)) <= allHours) {
            fullStatusList.add(Status.COMPLETE.getStatus());
        } else
            fullStatusList.add(Status.NOT_COMPLETE.getStatus() + " " + ((courseDurationList.get(0) + courseDurationList.get(1)) - allHours) + " hours left");
        if ((courseDurationList.get(2) + courseDurationList.get(0) + courseDurationList.get(1)) <= allHours) {
            fullStatusList.add(Status.COMPLETE.getStatus());
        } else
            fullStatusList.add(Status.NOT_COMPLETE.getStatus() + " " + ((courseDurationList.get(0) + courseDurationList.get(1) + courseDurationList.get(2)) - allHours) + " hours left");
    }

    private void printStatus () {
        System.out.printf("%s %s hours " + " Status: " + fullStatusList.get(0) + "\n", courseNameList.get(0), courseDurationList.get(0));
        System.out.printf("%s %s hours " + " Status: " + fullStatusList.get(1) + "\n", courseNameList.get(1), courseDurationList.get(1));
        System.out.printf("%s %s hours " + " Status: " + fullStatusList.get(2) + "\n", courseNameList.get(2), courseDurationList.get(2));
    }

    static String convertLaunchDate(String dateOfLaunchToReport) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat formatter2 = new SimpleDateFormat("dd MMMM yyyy, EEEE");
        Date date = formatter.parse(dateOfLaunchToReport);
        String formatDate = formatter2.format(date);
        return formatDate;
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
