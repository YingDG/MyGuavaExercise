package yingdg.exercise.functions.function;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by YingDG on 2017/2/6.
 */
public class FunctionsEx {
    /*
    string -> date
     */
    public static Function<String, Date> dateStringFunction = new Function<String, Date>() {
        @Override
        public Date apply(String input) {
            try {
                return new SimpleDateFormat("yyyyMMdd").parse(input);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return null;
        }
    };

    // 拼接函数功能
    public Function<Long, Date> function = Functions.compose(dateStringFunction, new IFunctionEx());

    @Test
    public void functionsTest() {
        Date date = dateStringFunction.apply("20170206");
        System.out.println(date);

        Date date1 = function.apply((long) 20170206);
        System.out.println(date1);
    }

}
