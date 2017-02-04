package yingdg.exercise.joiner;

import com.google.common.base.Joiner;
import org.junit.Test;

/**
 * Created by YingDG on 2017/1/21.
 */
public class JoinerEx {

    @Test
    public void joinerTest() {
        Joiner joiner = Joiner
                .on("/")
                .skipNulls();
        String[] ss = {"hello", "world", "!", null};
        String s = joiner.join(ss);
        System.out.println(s);
    }

}
