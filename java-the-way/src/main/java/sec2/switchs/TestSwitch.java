package sec2.switchs;

public class TestSwitch {
    private static int monthDays(int month, int year){
        return switch (month){
            case 1, 3, 5, 7, 10, 12 : yield  31;
            case 2 :{
                if (((year % 4)== 0) && (((year % 100) != 0) || ((year % 400) == 0)))
                    yield 29;
                yield 28;
            }
            default :  yield  30;
        };
    }

    public static void main(String[] args) {
        System.out.println("Month 2 has " + monthDays(2, 2000) + " days");
    }
}
