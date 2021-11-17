package report;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import status.Status;
import student.Course;
import student.Student;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Report {

    private String formatDate;
    private int hoursFromConsole;
    private int allHours;
    private static final String PATTERNDATE = "dd.MM.yyyy";
    private static final Logger logger = LogManager.getLogger();

    public void reportToConsole(Student student, String dateReport, String typeReport, String timeReport) throws ParseException {
        formatDate = convertLaunchDate(dateReport);
        int daysBetween = getDaysBetweenStartAndReport(student, dateReport);
        int numOfWeekends = (daysBetween / 7) * 2;
        if (daysBetween > 5) daysBetween -= numOfWeekends;      // с учётом рабочей недели
        hoursFromConsole = Integer.parseInt(timeReport);
        allHours = (daysBetween * 8) + (hoursFromConsole - 10);
        int hoursPass = (getSumDurationAllCourses(student) - allHours);
        getStatus(allHours, student);

        if (typeReport.equals("Short")) {
            shortReport(student, hoursPass);
        } else {   //если тип отчета full
            fullReport(student, hoursPass, numOfWeekends);
        }
    }

    private void shortReport(Student student, int hoursPass) {
       logger.info("(Generating report date - {}, {}:00):", formatDate, hoursFromConsole);
        if (hoursPass <= 0) {
            logger.info("{} {} - Training completed. {} have passed since the end.",
                    student.getName(), student.getCurriculum(), getDaysPass(hoursPass));
        } else {
            logger.info("{} {} - Training is not finished. {} are left until the end.",
                    student.getName(), student.getCurriculum(), getDaysPassNot(hoursPass));
        }
    }

    private String getDaysPass(int hoursPass) {
        return (-hoursPass / 8) + " days " + (-hoursPass % 8) + " hours";
    }

    private String getDaysPassNot(int hoursPass) {
        return hoursPass / 8 + " days " + hoursPass % 8 + " hours";
    }

    private void fullReport(Student student, int hoursPass, int numbOfWeekends) {
        logger.info(student.getName());
        if (hoursPass <= 0) {
            logger.info("working time (from 10 to 18): {} hours" + "\n", formatDate);
            printStatus(student);
            logger.info("start date: {}", student.getStartDate());
            logger.info("end date: {}", endDateCourse(student, numbOfWeekends));
            logger.info ("Training completed. {}  days have passed since the end.", getDaysPass(hoursPass));
        } else {
            logger.info("working time (from 10 to 18): {} hours", allHours);
            printStatus(student);
            logger.info("start date: {}", student.getStartDate());
            logger.info("end date: Not complete ");
            logger.info("Training is not completed. {} are left until the end.", getDaysPassNot(hoursPass));
        }
    }

    public List<String> getStatus(int allHours, Student student) {
      List<String>  fullStatusList = new ArrayList<>();
        int sum = 0;
        for (Course course : student.getCourseList()) {
            if (course.getDuration() <= allHours - sum) {
                fullStatusList.add(String.valueOf(Status.COMPLETE.getStatusType()));
            } else
                fullStatusList.add(Status.NOT_COMPLETE.getStatusType() + " " + (course.getDuration() - (allHours - sum)) + " hours left");
            sum += course.getDuration();
        }
        return fullStatusList;
    }

    private void printStatus(Student student) {
        int i = 0;
        for (Course course : student.getCourseList()) {

            logger.info("{} {} hours " + " status: {}",
                    course.getName(), course.getDuration(), getStatus(allHours, student).get(i));
            i++;
        }
    }

    public int getSumDurationAllCourses(Student student) {
        int sum = 0;
        for (Course course : student.getCourseList()) {
            sum += course.getDuration();
        }
        return sum;
    }

    private String convertLaunchDate(String dateOfLaunchToReport) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat(PATTERNDATE);
        SimpleDateFormat formatter2 = new SimpleDateFormat("dd MMMM yyyy, EEEE");
        Date date = formatter.parse(dateOfLaunchToReport);
        return formatter2.format(date);
    }

    public int getDaysBetweenStartAndReport(Student student, String dateOfLaunch) {
        DateTimeFormatter fmt2 = DateTimeFormat.forPattern(PATTERNDATE);
        DateTime dt3 = fmt2.parseDateTime(student.getStartDate());
        DateTime dt2 = fmt2.parseDateTime(dateOfLaunch);
        dt2.getDayOfWeek();
        return Days.daysBetween(dt3, dt2).getDays();  //вычисляем сколько дней прошло с момента старта
    }

    public String endDateCourse(Student student, int numbOfWeekends) {
        DateTimeFormatter fmt2 = DateTimeFormat.forPattern(PATTERNDATE);
        DateTime dt3 = fmt2.parseDateTime(student.getStartDate());
        DateTime endDateCourse = (dt3.plusDays(getSumDurationAllCourses(student) / 8 + numbOfWeekends));
        return endDateCourse.toString(fmt2);
    }

}
