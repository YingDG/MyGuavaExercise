package yingdg.exercise.basic.strings;

import com.google.common.base.Strings;
import org.junit.Test;

/**
 * Created by YingDG on 2017/2/4.
 */
public class StringsEx {
    private String testStr = "123 abc 232 a2b4c3";

    @Test
    public void stringsTest() {
        // 空字符串与null转换
        String s = Strings.nullToEmpty(null);
        System.out.println(s == null);
        String s2 = Strings.emptyToNull("");
        System.out.println(s2 == null);
        System.out.println(Strings.isNullOrEmpty(s));

        // 获取两个字符串的共同前、后缀
        String s3 = Strings.commonPrefix("123", testStr);
        System.out.println(s3);
        String s4 = Strings.commonSuffix("c3", testStr);
        System.out.println(s4);

        // 重复叠加相同字符串
        String repeat = Strings.repeat("abc", 3);
        System.out.println(repeat);

        // 补充单字符
        String start = Strings.padStart(testStr, 20, 'h');
        System.out.println(start);
        String end = Strings.padEnd(testStr, 20, 'w');
        System.out.println(end);
    }

}
