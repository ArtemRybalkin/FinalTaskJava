package report;

import console.ConsoleReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import models.Course;
import models.Student;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Report {

    private final Logger logger = LogManager.getLogger();
    private final PrepareDateForReport preparedDateForReport = new PrepareDateForReport();
    private final DateTimeFormatter dateFormatterForShortReport = DateTimeFormatter.ofPattern("d MMMM yyyy, EEEE HH");
    private String FormatEndTimeForShortReport;
    private final ConsoleReader reader = new ConsoleReader();

    public void reportToConsole(Student student) {

        LocalDateTime dateOfReport = preparedDateForReport.getDateOfReport(student);
        TypeOfReport typeOfReportFromConsole = reader.getTypeOfReportFromConsole();
        FormatEndTimeForShortReport = dateOfReport.format(dateFormatterForShortReport);
        int workedHours = preparedDateForReport.getWorkedHours(student.getStartDate(), dateOfReport);

        int hoursSpent = (student.getSumDurationAllCourses() - workedHours);
        if (typeOfReportFromConsole == TypeOfReport.SHORT_REPORT) {
            printShortReport(student, hoursSpent);
        } else {
            printFullReport(student, hoursSpent, workedHours);
        }
    }

    private void printShortReport(Student student, int hoursSpent) {
        logger.info("(Generating report date - {}:00):", FormatEndTimeForShortReport);
        if (hoursSpent <= 0) {
            logger.info("{} {} - Training completed. {} have passed since the end.",
                    student.getName(), student.getCurriculum(), getTimeAfterFinishCourse(hoursSpent));
        } else {
            logger.info("{} {} - Training is not finished. {} are left until the end.",
                    student.getName(), student.getCurriculum(), getTimeLeftToCompleteCourse(hoursSpent));
        }
    }

    private String getTimeAfterFinishCourse(int hoursSpent) {
        return (-hoursSpent / 8) + " days " + (-hoursSpent % 8) + " hours";
    }

    private String getTimeLeftToCompleteCourse(int hoursSpent) {
        return hoursSpent / 8 + " days " + hoursSpent % 8 + " hours";
    }

    private void printFullReport(Student student, int hoursSpent, int workedHours) {
        logger.info(student.getName());
        if (hoursSpent <= 0) {
            logger.info("working time (from 10 to 18): {} hours", student.getSumDurationAllCourses());
            printStatus(student, workedHours);
            logger.info("start date: {}", student.getStartDate().toLocalDate());
            logger.info("end date: {}",
                    getEndDateCourse(student.getStartDate(), student.getSumDurationAllCourses() / 8));
            logger.info("Training completed. {} have passed since the end.", getTimeAfterFinishCourse(hoursSpent));
        } else {
            logger.info("working time (from 10 to 18): {} hours", workedHours);
            printStatus(student, workedHours);
            logger.info("start date: {}", student.getStartDate());
            logger.info("end date: Not complete ");
            logger.info("Training is not completed. {} are left until the end.",
                    getTimeLeftToCompleteCourse(hoursSpent));
        }
    }

    public void printStatus(Student student, int workedHours) {
        int sum = 0;
        for (Course course : student.getCourseList()) {
            course.setStatus(workedHours, student);
            if (course.getDuration() <= workedHours - sum) {
                logger.info("{} {} hours status: {}",
                        course.getName(), course.getDuration(), course.getStatus().getStatusType());
            } else {
                logger.info("{} {} hours status: {} {} hours left",
                        course.getName(), course.getDuration(), course.getStatus().getStatusType(), (course.getDuration() - (workedHours - sum)));
            }
            sum += course.getDuration();
        }
    }

    public LocalDate getEndDateCourse(LocalDateTime startDate, int workedDays) {

        LocalDate endDateCourse = startDate.toLocalDate();
        int countWeekend;
        for (int i = 0; i <= workedDays; i++) {
            if ((endDateCourse.getDayOfWeek() == DayOfWeek.SUNDAY) || (endDateCourse.getDayOfWeek() == DayOfWeek.SATURDAY)) {
                countWeekend = 1;
            } else countWeekend = 0;
            endDateCourse = endDateCourse.plusDays(countWeekend + 1);
        }
        return endDateCourse;
    }
}

