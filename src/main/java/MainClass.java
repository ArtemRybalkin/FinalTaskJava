import report.*;
import models.*;

public class MainClass {

    public static void main(String[] args) {

        Report report = new Report();
        Student ivanov = new Developer("Ivanov Ivan", "Developer", "01.06.2020 10");
        Student sidorov = new AQE("Sidorov Ivan", "AQE", "01.06.2020 10");
        report.reportToConsole(ivanov);
        report.reportToConsole(sidorov);
    }
}
