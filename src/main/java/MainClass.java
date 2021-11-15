

import java.text.ParseException;
import java.util.Scanner;

public class MainClass {
    //    TODO сделать переменные приватными
//    TODO разбить на пакеты
    //TODO lombok
    // TODO логирование вместо sout

    //    создали первого персонажа
   final static Student ivanov = new Developer("Ivanov Ivan", "Developer", "01.06.2020");
    //   создали второго персонажа
   final static Student sidorov = new AQE("Sidorov Ivan", "AQE", "01.06.2020");
    //        прочитали из консоли дату
    private static final String dateOfLaunch = ReadFromConsole.getDateOfLaunch();
    //        прочитали из консоли тип отчета
    private static final String typeReport = ReadFromConsole.getTypeOfReport();
    //        прочитали из консоли время отчета
    private static final String timeReport = ReadFromConsole.getTimeReport();
//    var
    public static void main(String[] args) throws ParseException {
        Report report = new Report();
        Person person = new Person();
        person.getName();
//        вывели отчет
        report.reportToConsole(ivanov, dateOfLaunch, typeReport, timeReport);
        report.reportToConsole(sidorov, dateOfLaunch, typeReport, timeReport);
    }
}
