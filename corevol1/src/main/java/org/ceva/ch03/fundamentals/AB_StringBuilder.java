package org.ceva.ch03.fundamentals;

import java.io.StringWriter;

public class AB_StringBuilder {
    public static void main(String[] args) {
        multilineDemo();
    }

    private static void multilineDemo(){
        String newLineCh = System.lineSeparator();

        // String.concat()
        String multiLineStr = "line one of the text block"
                .concat(newLineCh)
                .concat("line two of the text block")
                .concat(newLineCh)
                .concat("last line of the text block");

        multiLineStr = "";

        // String.join()
        multiLineStr = String.join("line one of the text block",
                newLineCh,
                "line two of the text block",
                newLineCh,
                "last line of the text block");

        // StringBuffer
        var strBuffer = new StringBuffer("line one of the text block")
                .append(newLineCh)
                .append("line two of the text block")
                .append(newLineCh)
                .append("last line of the text block")
                .toString();


        // StringBuilder
        var strBuilder = new StringBuilder("line one of the texto block")
                .append(newLineCh)
                .append("line two of the text block")
                .append(newLineCh)
                .append("last line of the text block");

        // StringWriter
        var stringWriter = new StringWriter();
        stringWriter.write("line one of the text block");
        stringWriter.write(newLineCh);
        stringWriter.write("line two of the text block");
        stringWriter.write(newLineCh);
        stringWriter.write("last line of the text block");


        System.out.println(stringWriter);
    }
}
