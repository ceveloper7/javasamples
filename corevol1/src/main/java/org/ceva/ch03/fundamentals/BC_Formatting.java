package org.ceva.ch03.fundamentals;

import java.text.MessageFormat;
import java.util.Calendar;
import java.util.Formatter;
import java.util.Locale;

public class BC_Formatting {
    public static void main(String[] args) {
        simpleFormatting();
        formattingWithLocale();
        formattingCalendar();
        buildingStringFormatter();
    }

    private static void buildingStringFormatter(){
        var sb = new StringBuilder();
        double x = 50.5;
        double y = 70.60;
        double distance = 18563.80;

        Formatter fmt = new Formatter(sb, Locale.US);
        fmt.format("\nDistance of Point(" + x + ", " + y + ") from origin is %,.02f", distance);
        System.out.println(sb.toString());
    }

    private static void formattingCalendar(){
        Calendar calendar = Calendar.getInstance();
        //especificadores de formato para fecha y horas
        System.out.printf("The current local time is %tr on " + "%<tA, %<tB %<te, %<tY.%n", calendar);
        System.out.printf(Locale.FRANCE, "The current local time is %tr on " + "%<tA, %<tB %<te, %<tY.%n", calendar);
        System.out.printf(Locale.GERMANY, "The current local time is %tr on " + "%<tA, %<tB %<te, %<tY.%n", calendar);
    }

    private static void simpleFormatting(){
        float rate = 12.5f;
        int quantity = 100;
        float total = 1250;

        /**
         * Indices de argumentos:
         * 1$ -> rate
         * 2$ -> quantity
         * 3$ -> total
         */
        System.out.printf("Rate: %1$.2f Quantity: %2$d Total: %3$,.2f\n", rate, quantity, total);
        System.out.printf("Total: %3$,.2f Quantity:%2$d Rate:%1$.2f\n\n", rate, quantity, total);

        var ff = String.format("I have %,.2f, bugs to fix.\n", 476578.09875);
        System.out.println(ff);

        System.out.println("Simple format: " + String.format("%,6.1f", 42.010));

        // MessageFormat
        System.out.println(MessageFormat.format("My name is {0} and I am {1} years old", "Pedro", 35));
    }

    private static void formattingWithLocale(){
        float f = (float) 123456789.98;
        System.out.printf("US - Price: %,.2f\n", f);
        // punto flotate con configuracion regional
        System.out.printf(Locale.FRANCE, "France - Price: %,.2f\n", f);
        System.out.printf(Locale.GERMANY, "German - Price: %,.2f\n", f);
        System.out.printf(Locale.CHINA, "China - Price: %,.2f\n\n", f);
    }
}
