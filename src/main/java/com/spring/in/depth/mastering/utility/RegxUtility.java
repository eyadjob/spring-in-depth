package com.spring.in.depth.mastering.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegxUtility {

    public static String getRegxMatch(String regx, int group, String text) {
        Pattern p = Pattern.compile(regx);
        Matcher m = p.matcher(text);
        if (m.find()) {
            System.out.println(m.group(0));
            return m.group(group);
        } else return "";
    }

    public static List<String> getRegxMatchList(String regx, int groupIndex, String text) {
        Pattern p = Pattern.compile(regx);
        Matcher m = p.matcher(text);
        List<String> result = new ArrayList<>();
        if (m.find()) {
            result.add(m.group(groupIndex));
        }
        return result;
    }

}
