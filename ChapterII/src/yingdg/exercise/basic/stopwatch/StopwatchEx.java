package yingdg.exercise.basic.stopwatch;

import com.google.common.base.Stopwatch;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by YingDG on 2017/2/4.
 */
public class StopwatchEx {
    private String testStr = "123 abc 232 a2b4c3";

    @Test
    public void stopwatchTest() {
        Stopwatch stopwatch = Stopwatch.createStarted();

        // 延迟3秒
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long time = stopwatch.elapsed(TimeUnit.SECONDS);
        System.out.println(time);
    }

}
