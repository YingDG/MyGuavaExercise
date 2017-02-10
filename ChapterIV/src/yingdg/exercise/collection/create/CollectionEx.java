package yingdg.exercise.collection.create;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by YingDG on 2017/2/4.
 */
public class CollectionEx {

    @Test
    public void collectionTest() {
        HashMap<Integer, User> map1 = Maps.newHashMap();
        map1.put(1, new User("a", "a", 1));
        map1.put(2, new User("b", "b", 2));
        System.out.println(map1);

        ArrayList<User> users = Lists.newArrayList(
                new User("a", "a", 1),
                new User("b", "b", 2));
        System.out.println(users);

        HashSet<User> users1 = Sets.newHashSet(
                new User("a", "a", 1),
                new User("a", "a", 1));
        System.out.println(users1);
    }

}
