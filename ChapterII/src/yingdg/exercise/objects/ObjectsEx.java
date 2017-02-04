package yingdg.exercise.objects;

import com.google.common.base.Objects;
import org.junit.Test;

/**
 * Created by YingDG on 2017/2/4.
 */
public class ObjectsEx {

    @Test
    public void objectsTest() {
        User user = new User("yingdg", "123", 26);
        System.out.println(user);

        User user2 = user;
        System.out.println(Objects.equal(user, user2));
        System.out.println(Objects.equal(user, new User()));
    }
}
