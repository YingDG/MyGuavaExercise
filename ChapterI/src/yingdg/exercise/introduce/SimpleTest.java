package yingdg.exercise.introduce;

import com.google.common.base.Strings;
import org.junit.Test;

/**
 * Created by YingDG on 2017/1/21.
 */
public class SimpleTest {

    /*
    牛刀小试
     */
    @Test
    public void simpleTest() {
        System.out.println(Strings.isNullOrEmpty(null));
        System.out.println(Strings.isNullOrEmpty(""));
    }

}
