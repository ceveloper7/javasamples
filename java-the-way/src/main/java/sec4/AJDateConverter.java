package sec4;

import java.util.Calendar;

public class AJDateConverter {
    public static java.util.Date parseToDate(String strDate){
        int date, month, year;

        if ((strDate == null) || (strDate.isBlank()))
            return null;

        int idx0 = strDate.indexOf('/');
        // validamos que la fecha incluya / como separador
        if (idx0 == -1)
            return null;

        // procesamiento del string date
        String tmp = strDate.substring(0, idx0);
        date = Integer.parseInt(tmp);

        // buscamos la siguiente diagonal
        int idx1 = strDate.indexOf('/', idx0+1);
        if(idx1 == -1)
            return null;
        tmp = strDate.substring(idx0+1, idx1);
        month = Integer.parseInt(tmp);

        tmp = strDate.substring(idx1+1);
        year = Integer.parseInt(tmp);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE, date);
        cal.set(Calendar.MONTH, month-1);
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        return cal.getTime();
    }

    public static void main(String[] args) {
        java.util.Date date = parseToDate("15/07/2025");
        System.out.println("Date is " + date);
    }
}
