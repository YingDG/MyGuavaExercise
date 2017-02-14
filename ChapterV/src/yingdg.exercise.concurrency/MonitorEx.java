package yingdg.exercise.concurrency;

import com.google.common.util.concurrent.Monitor;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YingDG on 2017/2/13.
 */
public class MonitorEx {
    private List<String> strings = new ArrayList<>();
    private static final int MAX_ITEM_SIZE = 3;
    private Monitor monitor = new Monitor();

    private Monitor.Guard guard = new Monitor.Guard(monitor) {
        // 并发访问次数限制
        @Override
        public boolean isSatisfied() {
            return strings.size() < MAX_ITEM_SIZE;
        }
    };

    public void addItem(String item) throws InterruptedException {
        /*
        Monitor.enterIf：条件来判断是否可进入Monitor代码块
        Monitor.enter : 进入Monitor块，将阻塞其他线程直到Monitor.leave
        Monitor.tryEnter : 尝试进入Monitor块，且不会一直阻塞
        Monitor.tryEnterIf :根据条件尝试进入Monitor块
         */
        monitor.enterWhen(guard);
        try {
            strings.add(item);
        } finally {
            monitor.leave();
        }
    }

    @Test
    public void monitorTest() throws InterruptedException {
        int i = 0;
        this.addItem("" + i++);
        this.addItem("" + i++);
        this.addItem("" + i++);
        // 再加一个请求会出现阻塞
        // this.addItem("" + i++);

        System.out.println(this.strings);
    }
}

