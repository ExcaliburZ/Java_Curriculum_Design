package net.wings.web.tag;

/**
 * Created by wing on 2014/10/19.
 */
public class HtmlFilterTag {
    public static java.lang.String filter(String str) {

        if (str.length() < 10) {
        }
        else {
            str = str.substring(0,7)+"...";
        }
        return str;
    }
}
