package yingdg.exercise.collection.sort;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import org.junit.Before;
import org.junit.Test;
import yingdg.exercise.collection.create.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YingDG on 2017/2/10.
 */
public class CollectionSortEx2 {
    private List<User> userList;

    @Before
    public void init() {
        userList = Lists.newArrayList(
                new User("a", "a", 1),
                new User("b", "b", 0)
        );
    }

    @Test
    public void collectionSortTest() {
        // 自定义比较器
        Ordering<User> onAge = new Ordering<User>() {
            @Override
            public int compare(User a, User b) {
                // age从大到小
                return a.getAge() - b.getAge();
            }
        };

        ImmutableList<User> users = onAge.immutableSortedCopy(userList);
        System.out.println(users);
    }
}
