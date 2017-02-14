package yingdg.exercise.collection.sort;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YingDG on 2017/2/10.
 */
public class CollectionSortEx {

    @Test
    public void collectionSortTest() {
        ArrayList<Integer> integers = Lists.newArrayList(4, 3, 8, 0, 1, 7, 2);

        List<Integer> integers1 = Ordering.natural().sortedCopy(integers);
        System.out.println(integers1);
        System.out.println(Objects.equal(integers, integers1));

        List<Integer> integers2 = Ordering.natural().reverse().nullsLast().sortedCopy(integers);
        System.out.println(integers2);

        Integer min = Ordering.natural().min(integers);
        System.out.println(min);
        Integer max = Ordering.natural().max(integers);
        System.out.println(max);
    }
}
