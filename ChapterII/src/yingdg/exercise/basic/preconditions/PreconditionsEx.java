package yingdg.exercise.basic.preconditions;

import static com.google.common.base.Preconditions.checkNotNull;

import org.junit.Test;

/**
 * Created by YingDG on 2017/2/4.
 */
public class PreconditionsEx {
    private String testStr = "abc";

    @Test
    public void preconditionsTest() {
        String result = null;
        // checkNotNull(result);

        checkNotNull(testStr);
        System.out.println(testStr);
    }

}
