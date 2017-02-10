package yingdg.exercise.predicate;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.junit.Test;

/**
 * Created by YingDG on 2017/2/10.
 */
public class PredicateEx {

    @Test
    public void predicateTest() {
        Predicate<Integer> predicate = Predicates.and(new IPredicateEx(), new IPredicateEx2());
        System.out.println(predicate.apply(80));
        System.out.println(predicate.apply(101));

        Predicate<Integer> predicate1 = Predicates.or(new IPredicateEx(), new IPredicateEx2());
        System.out.println(predicate1.apply(101));
    }
}
