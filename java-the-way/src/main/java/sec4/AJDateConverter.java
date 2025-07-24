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
        if ((date < 0) || (date > 31))
            return null;

        // buscamos la siguiente diagonal
        int idx1 = strDate.indexOf('/', idx0+1);
        if(idx1 == -1)
            return null;
        tmp = strDate.substring(idx0+1, idx1);
        month = Integer.parseInt(tmp);
        if ((month < 1) || (month > 12))
            return null;

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

    /**
     * Algoritmo para analizar el formato
     *
     * Param        significado
     * =====        ===========
     * dd           day
     * mm           month
     * yyyy         year (el anio puede tener 4 o 2 digitos)
     * hh           hour
     * MM           minute
     * ss           second
     *
     * parseDateToAnotherDateFormat("01/02/2020", "dd/mm/yyyy") -> 1 febrero, 2020
     * parseDateToAnotherDateFormat("01/02/2020", "mm/dd/yyyy") -> Enero 2, 2020
     *
     * @param strDate
     * @param newFormat
     * @return
     */
    public static void parseDateToAnotherDateFormat(String newFormat){
        String[] reserved = {
                "dd", "mm", "yyyy", "hh", "MM", "ss"
        };

//        if((strDate == null) || (strDate.isEmpty()))
//            ;
        if((newFormat == null) || (newFormat.isEmpty()))
            ;


        for(int i = 0, count = 0 ; i < newFormat.length()-1; i++){
            char f = newFormat.charAt(i);
            for (int j = 0; j < reserved.length; j++){
                if (reserved[j].contains(String.valueOf(f))){
                    count++;
                    char s = newFormat.charAt(i+1);
                    if (f == s){
                        count++;
                        i += 1;
                    }
                }
            }
            System.out.println(count);
            count = 0;
        }
    }

    public static void main(String[] args) {

        parseDateToAnotherDateFormat("dd/mm/yyyy");
    }
}
