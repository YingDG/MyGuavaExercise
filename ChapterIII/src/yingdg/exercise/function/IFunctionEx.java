package yingdg.exercise.function;

import com.google.common.base.Function;

/**
 * Created by YingDG on 2017/2/6.
 */
public class IFunctionEx implements Function<Long, String> {
    /*
    long -> string
     */
    @Override
    public String apply(Long input) {
        return String.valueOf(input);
    }

    public static void main(String[] args) {
        String s = new IFunctionEx().apply((long) 123);
        System.out.println(s instanceof String);
    }
}
