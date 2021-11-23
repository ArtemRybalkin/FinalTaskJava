package report;

import console.ConsoleReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import models.Course;
import models.Student;
import java.time.LocalDateTime;

public class Report {

    private final Logger logger = LogManager.getLogger();
    private int workedHours;
    PrepareDates prep = new PrepareDates();
    ConsoleReader reader = new ConsoleReader();

    public void reportToConsole(Student student) {
        prep.convertDate(student);
        workedHours = prep.getWorkedHours();
       TypeOfReport typeOfReport = reader.getTypeOfReport();
        int hoursPass = (student.getSumDurationAllCourses() - workedHours);
        if (typeOfReport == TypeOfReport.SHORT_REPORT) {
            shortReport(student, hoursPass);
        } else {
            fullReport(student, hoursPass);
        }
    }

    private void shortReport(Student student, int hoursPass) {
        logger.info("(Generating report date - {}:00):", prep.endTimeFormated);
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

    private void fullReport(Student student, int hoursPass) {
        logger.info(student.getName());
        if (hoursPass <= 0) {
            logger.info("working time (from 10 to 18): {} hours", student.getSumDurationAllCourses());
            printStatus(student);
            logger.info("start date: {}", prep.startTime.toLocalDate());
            logger.info("end date: {}", endDateCourse());
            logger.info("Training completed. {} have passed since the end.", getDaysPass(hoursPass));
        } else {
            logger.info("working time (from 10 to 18): {} hours", workedHours);
            printStatus(student);
            logger.info("start date: {}", student.getStartDate());
            logger.info("end date: Not complete ");
            logger.info("Training is not completed. {} are left until the end.", getDaysPassNot(hoursPass));
        }
    }

    private void printStatus(Student student) {
        for (Course course : student.getCourseList()) {
            course.setStatus(workedHours, student);
            logger.info("{} {} hours " + "status: {}", course.getName(), course.getDuration(), course.getStatus());
        }
    }

    public LocalDateTime endDateCourse() {
        return prep.startTime.plusDays(prep.getWorkedHours() / 8);
    }

}
