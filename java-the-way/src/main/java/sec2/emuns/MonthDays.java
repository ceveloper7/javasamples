package sec2.emuns;

public enum MonthDays {
    JAN(31),
    FEB(28),
    MAR(31),
    APR(30),
    MAY(31),
    JUN(30),
    JUL(31),
    AUG(31),
    SEP(30),
    OCT(31),
    NOV(30),
    DIC(31);

    private final int nDays;

    MonthDays(int nDays){
        this.nDays = nDays;
    }

    public int getDays(){
        return nDays;
    }

    public static void testNUmDays(int month){
        if(month >= 1 && month <= 12){
            MonthDays md = MonthDays.values()[month-1];
            System.out.println(md +" tiene " + md.getDays() + " dias");
        }else {
            System.err.println("Error, numero de mes incorrecto");
        }
    }

    public static void main(String[] args) {
        testNUmDays(-12);
    }
}
