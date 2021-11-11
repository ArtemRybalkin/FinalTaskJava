public class MainClass {

   static Student ivanov = new Developer(StudentIvanov.NAME.getValue(), "Java Developer", "01.06.2020", Developer.Courses );
   static Student sidorov = new AQE("Sidorov Ivan", "AQE", "01.06.2020", AQE.Courses);



    public static void main(String[] args)  {

//        прочитать из консоли дату
        ReadFromConsole.getDateOfLaunch();
//        прочитать из консоли тип отчета
       ReadFromConsole.getTypeOfReport();
//        вывести отчет
        Report.reportToConsole(ivanov);
        Report.reportToConsole(sidorov);
    }

}
