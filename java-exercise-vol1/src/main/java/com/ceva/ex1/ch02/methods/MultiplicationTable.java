package com.ceva.ex1.ch02.methods;

public class MultiplicationTable {

    private static final int BASE_PRICE_FLAMETHROWER = 500;
    private static final int BASE_PRICE_FIRE_EXTINGUISHER = 100;

    private void startHtml(){
        System.out.println("<html>");
    }

    private void endHtml(){
        System.out.println("</html>");
    }

    private void startTable(){
        System.out.println("<table>");
    }

    private void endTable(){
        System.out.println("</table>");
    }

    private void startRow(){
        System.out.print("<tr>");
    }

    private void endRow(){
        System.out.println("</tr>");
    }

    private void headerCell(String value){
        System.out.print("<th>" + value + "</th>");
    }

    private void dataCell(String value){
        System.out.print("<td>" + value + "</td>");
    }

    private void dataCell(int value){
        dataCell(Integer.toString(value));
    }

    public static void main(String[] args) {
        MultiplicationTable mt = new MultiplicationTable();
        mt.startHtml();
            mt.startTable();
                mt.startRow();
                    mt.headerCell("QUANTITY");
                    mt.headerCell("FLAMETHROWER");
                    mt.headerCell("FIRE EXTINGUISHER");
                mt.endRow();
                for(int i = 1; i <= 10; i++){
                    mt.startRow();
                        mt.dataCell(i);
                        mt.dataCell(i * BASE_PRICE_FLAMETHROWER);
                        mt.dataCell(i * BASE_PRICE_FIRE_EXTINGUISHER);
                    mt.endRow();
                }
            mt.endTable();
        mt.endHtml();
    }
}
