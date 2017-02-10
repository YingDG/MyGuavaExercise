package yingdg.exercise.basic.optional;

import com.google.common.base.Optional;
import org.junit.Test;

/**
 * Created by YingDG on 2017/2/6.
 */
public class OptionalEx {

    @Test
    public void optionalTest() {
        Optional<Integer> optional = Optional.of(5);
        System.out.println(optional.isPresent());

        Optional<Object> optional2 = Optional.fromNullable(null);
        System.out.println(optional2.isPresent());

        Optional<String> absent = Optional.absent();
        System.out.println(absent.isPresent());
    }
}
