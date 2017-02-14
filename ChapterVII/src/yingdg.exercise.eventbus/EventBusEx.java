package yingdg.exercise.eventbus;

import com.google.common.eventbus.AllowConcurrentEvents;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import org.junit.Test;

/**
 * Created by YingDG on 2017/2/13.
 */
public class EventBusEx {

    // 支持多个
    @Subscribe
    @AllowConcurrentEvents
    public void listen(MyEvent event) {
        System.out.println(event.getMes());
    }

    @Subscribe
    public void listen2(MyEvent event) {
        System.out.println("listen2: " + event.getMes());
    }

    @Test
    public void eventBusTest() {
        EventBus eventBus = new EventBus();
        EventBusEx ex = new EventBusEx();
        eventBus.register(ex);

        eventBus.post(new MyEvent("Hello"));
        eventBus.post(new MyEvent("World"));
    }
}

class MyEvent {
    private String mes;

    public MyEvent(String mes) {
        this.mes = mes;
    }

    public String getMes() {
        return mes;
    }
}
