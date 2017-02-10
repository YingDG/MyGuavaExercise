package yingdg.exercise.basic.splitter;

import com.google.common.base.Splitter;
import org.junit.Test;

/**
 * Created by YingDG on 2017/1/21.
 */
public class SplitterEx {
    private String testStr = "hello, world,, ,!!";

    @Test
    public void splitterTest() {
        Iterable<String> strings = Splitter
                .on(",")
                .omitEmptyStrings()
                .limit(3)
                .split(testStr);
        for (String s : strings) {
            System.out.println(s);
        }
    }

}
