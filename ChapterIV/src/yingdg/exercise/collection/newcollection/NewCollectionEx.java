package yingdg.exercise.collection.newcollection;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.junit.Test;
import yingdg.exercise.collection.create.User;

import java.util.Collection;

/**
 * Created by YingDG on 2017/2/10.
 */
public class NewCollectionEx {

    @Test
    public void newCollectionTest() {
        /*MultiMap,
            一种key可以重复的map，
            子类有ListMultimap和SetMultimap，对应的通过key分别得到list和set
         */
        Multimap<String, User> map = ArrayListMultimap.create();
        map.put("a", new User("a", "a", 1));
        map.put("a", new User("a", "a", 1));
        Collection<User> users = map.get("a");
        System.out.println(users);

        /*

         */
    }
}
