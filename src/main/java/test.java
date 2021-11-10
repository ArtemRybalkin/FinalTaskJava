public class test {
   enum NAME {
       NAME,
       SecondName
   }

    static   String name = NAME.NAME.toString();
   public static void test2 () {
       System.out.println(name);
   }
}
