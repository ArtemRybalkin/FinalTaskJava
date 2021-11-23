package report;

import console.ConsoleReader;
import models.Student;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PrepareDates {

    private static final int BEGINWORKHOUR = 10;
    private static final int ENDWORKHOUR = 18;

    private LocalDateTime endTime;
    LocalDateTime startTime;
    String endTimeFormated = "";
    private final Logger logger = LogManager.getLogger();
    ConsoleReader reader = new ConsoleReader();

    public void convertDate(Student student) {

        int count;
        do {
            try {

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.MM.yyyy H");
                DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("d MMMM yyyy, EEEE HH");
                startTime = LocalDateTime.parse(student.getStartDate(), formatter);
                endTime = LocalDateTime.parse(reader.getDateOfLaunch(), formatter);
                endTimeFormated = endTime.format(formatter2);
                count = 0;
                if (startTime.isAfter(endTime)) {
                    logger.info("Please insert date after start");
                    count = 1;
                }
                if ((endTime.getDayOfWeek() == DayOfWeek.SUNDAY) || endTime.getDayOfWeek() == DayOfWeek.SATURDAY) {
                    logger.info("Please insert not weekend");
                    count = 1;
                }
                if (endTime.getHour() > ENDWORKHOUR || endTime.getHour() < BEGINWORKHOUR) {
                    logger.info("Please insert correct time");
                    count = 1;
                }
            } catch (Exception e) {
                logger.info(e.getMessage());
                count = 1;
            }
        } while (count != 0);
    }

    public int getWorkedHours() {

        int workedHours = 0;
        while (!sameDay(startTime, endTime)) {
            workedHours += workedHoursDay(startTime);
            startTime = startTime.plusDays(1);
        }
        workedHours += ((endTime.getHour()) - startTime.getHour());
        return workedHours;
    }

    private int workedHoursDay(LocalDateTime startTime) {
        if ((startTime.getDayOfWeek() == DayOfWeek.SUNDAY) || (startTime.getDayOfWeek() == DayOfWeek.SATURDAY))
            return 0;
        else return (ENDWORKHOUR - startTime.getHour());
    }

    private boolean sameDay(LocalDateTime startTime, LocalDateTime endTime) {
        return startTime.getYear() == endTime.getYear() && startTime.getMonth() == endTime.getMonth() &&
                startTime.getDayOfMonth() == endTime.getDayOfMonth();
    }
}
