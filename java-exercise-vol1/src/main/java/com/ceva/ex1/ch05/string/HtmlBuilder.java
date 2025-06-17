package com.ceva.ex1.ch05.string;

public class HtmlBuilder {
    private static String htmlElement(String tag, String body){
        if(tag == null)
            tag = "";
        if(body ==  null)
            body = "";
        if (tag.isEmpty())
            return body;
        else
            return "<" + tag + ">" + body + "</" + tag + ">";
    }

    private static String strong(String body){
        return htmlElement("strong", body);
    }

    private static String emphasized(String body){
        return htmlElement("em", body);
    }

    public static void main(String[] args) {
        System.out.println(htmlElement("strong", "strong is bold"));
        System.out.println(strong(emphasized("strong+emphasized")));
        System.out.println(htmlElement("span", null));
        System.out.println(htmlElement(null, "not strong"));
        System.out.println(htmlElement(null, null));

    }
}
