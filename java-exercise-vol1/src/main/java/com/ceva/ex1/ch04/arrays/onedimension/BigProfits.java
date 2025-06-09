package com.ceva.ex1.ch04.arrays.onedimension;

/**
 * Arrays: Detect continous revenue growth
 */
public class BigProfits {
    private static final int MIN_PERCENTAGE_INCREASE = 5;

    private static int count5PercentJumps(int[] dailyGains){
        if (dailyGains.length < 2)
            return 0;

        int count = 0;
        for(int i = 1; i < dailyGains.length; i++){
            double yesterdayGain = dailyGains[i - 1];
            double todayGain = dailyGains[i];

            // formula para obtener el porcentaje entre dos ventas
            double percent = (todayGain / yesterdayGain) * 100 - 100;
            if(percent > MIN_PERCENTAGE_INCREASE)
                // jump sales done
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] dailySales = {68000, 95000, 78000, 100000, 88000};
        System.out.println("Number of jump sales is: " + count5PercentJumps(dailySales));
    }
}
