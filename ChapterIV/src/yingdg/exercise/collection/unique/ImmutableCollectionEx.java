package yingdg.exercise.collection.unique;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;
import org.junit.Test;

/**
 * Created by YingDG on 2017/2/10.
 */
public class ImmutableCollectionEx {
    @Test
    public void immutableCollectionTest() {
        // 创建不可变的集合
        ImmutableSet<Integer> immutableSet = ImmutableSet.of(1, 2, 3);
        ImmutableSet<Integer> immutableSet1 = ImmutableSet.copyOf(immutableSet);
        ImmutableSet<Integer> immutableSet2 = ImmutableSet.<Integer>builder().addAll(immutableSet1).build();
        System.out.println(immutableSet2);
        System.out.println(Objects.equal(immutableSet, immutableSet1));
    }
}
