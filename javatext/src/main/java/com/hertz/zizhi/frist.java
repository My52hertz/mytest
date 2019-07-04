package com.hertz.zizhi;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author sunyi,
 * @date 2019/6/13,
 * @time 15:52,
 */
public class frist {
    // (0 + 0) / 10000]19/06/13 07:42:39 WARN TaskSchedulerImpl: Initial job has not accepted any resources; check your cluster UI to ensure that workers
    public static void main(String[] args) {
        String str = " (0 + 0) / 10000]19/06/13 07:42:39 WARN TaskSchedulerImpl: Initial job has not accepted any resources; check your cluster UI to ensure that workers ";
        String s = str.split("/ ")[1].split(" ")[0];
        Pattern compile = Pattern.compile("\\d{2}/\\d{2}/\\d{2}");
        Matcher matcher = compile.matcher(str);
        if (matcher.find()) {
            System.out.println(matcher.group());
        }

    }

}
