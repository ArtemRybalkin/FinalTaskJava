package report;

import console.ConsoleReader;
import models.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PrepareDates {

    private static final int START_WORK_HOUR = 10;
    private static final int END_WORK_HOUR = 18;
    private final DateTimeFormatter formatterForDateOfReport = DateTimeFormatter.ofPattern("d.MM.yyyy H");
    private final Logger logger = LogManager.getLogger();
    private final ConsoleReader reader = new ConsoleReader();

    public LocalDateTime getDateOfReport(Student student) {

        LocalDateTime startDate = student.getStartDate();
        LocalDateTime dateOfReport = null;
        boolean isComplete;
        do {
            try {
                dateOfReport = LocalDateTime.parse(reader.getDateOfReportFromConsole(), formatterForDateOfReport);
                isComplete = true;
                if (startDate.isAfter(dateOfReport)) {
                    logger.info("Please insert date after start");
                    isComplete = false;
                }
                if ((dateOfReport.getDayOfWeek() == DayOfWeek.SUNDAY) || dateOfReport.getDayOfWeek() == DayOfWeek.SATURDAY) {
                    logger.info("Please insert not weekend");
                    isComplete = false;
                }
                if (dateOfReport.getHour() > END_WORK_HOUR || dateOfReport.getHour() < START_WORK_HOUR) {
                    logger.info("Please insert correct time");
                    isComplete = false;
                }
            } catch (Exception e) {
                logger.info(e.getMessage());
                isComplete = false;
            }
        } while (!isComplete);
        return dateOfReport;
    }

    public int getWorkedHours(LocalDateTime startDate, LocalDateTime dateOfReport) {

        int workedHours = 0;
        while (!sameDay(startDate, dateOfReport)) {
            workedHours += workedHoursAtOneDay(startDate);
            startDate = startDate.plusDays(1);
        }
        workedHours += ((dateOfReport.getHour()) - startDate.getHour());
        return workedHours;
    }

    private int workedHoursAtOneDay(LocalDateTime startDate) {

        if ((startDate.getDayOfWeek() == DayOfWeek.SUNDAY) || (startDate.getDayOfWeek() == DayOfWeek.SATURDAY))
            return 0;
        else return (END_WORK_HOUR - startDate.getHour());
    }

    private boolean sameDay(LocalDateTime startDate, LocalDateTime dateOfReport) {
        return startDate.getYear() == dateOfReport.getYear() && startDate.getMonth() == dateOfReport.getMonth() &&
                startDate.getDayOfMonth() == dateOfReport.getDayOfMonth();
    }
}
