package sec4;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class AKHandlingDates {

    private static void parseSimpleDateFormat(String date, String format) throws Exception{
        Date dt = new SimpleDateFormat(format).parse(date);

        System.out.println(dt.toString());
    }

    private static void date1(){
        Date d = new Date();
        System.out.println("java.util.Date " + d);

        Calendar cal = Calendar.getInstance();
        System.out.println("java.util.Calendar " + cal.getTime());

        LocalDate now = LocalDate.now();
        System.out.println("java.time.LocalDate " + now);
    }

    private static void date2(){
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.getTime());

        cal.add(Calendar.DATE, 1);
        cal.add(Calendar.HOUR, 1);
        System.out.println(cal.getTime());

        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int date = cal.get(Calendar.DATE);

        System.out.printf("year: %d, month: %d, day: %d", year, month, date);
    }

    private static void date3(){
        LocalDate ld = LocalDate.now();
        System.out.println(ld);

        ld = ld.plusDays(1);
        System.out.println(ld);

        int year = ld.getYear();
        int month = ld.getMonthValue();
        int day = ld.getDayOfMonth();

        System.out.printf("year: %d, month: %d, day: %d", year, month, day);
    }

    public static void main(String[] args) throws Exception{
        //parseSimpleDateFormat("01/04/2020", "MM/dd/yyyy");
        date3();
    }
}
