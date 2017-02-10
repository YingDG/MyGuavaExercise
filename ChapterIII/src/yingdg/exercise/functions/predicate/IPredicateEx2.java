package yingdg.exercise.functions.predicate;


import com.google.common.base.Predicate;

/**
 * Created by YingDG on 2017/2/6.
 */
public class IPredicateEx2 implements Predicate<Integer> {
    @Override
    public boolean apply(Integer input) {
        return input > 60;
    }

    public static void main(String[] args) {
        System.out.println(new IPredicateEx2().apply(99));
    }
}
