package yingdg.exercise.predicate;


import com.google.common.base.Predicate;

/**
 * Created by YingDG on 2017/2/6.
 */
public class IPredicateEx implements Predicate<Integer> {
    @Override
    public boolean apply(Integer input) {
        return input < 100;
    }

    public static void main(String[] args) {
        System.out.println(new IPredicateEx().apply(99));
    }
}
