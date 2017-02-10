package yingdg.exercise.collection.newcollection;

import com.google.common.collect.*;
import org.junit.Test;
import yingdg.exercise.collection.create.User;

import java.util.Collection;
import java.util.Map;

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

        /*MultiSet,
            不是集合，可以增加重复的元素，并且可以统计出重复元素的个数
         */
        HashMultiset<Integer> set = HashMultiset.create();
        set.add(1);
        set.add(1);
        set.add(2);
        System.out.println(set.count(1));
        System.out.println(set.size());
        System.out.println(set);

        /*Table,
            有两个key的map,即矩阵
         */
        HashBasedTable<Integer, Integer, String> table = HashBasedTable.create();
        table.put(0, 0, "0");
        table.put(0, 1, "1");
        table.put(1, 0, "2");
        Map<Integer, String> row = table.row(0);
        System.out.println(row);
        System.out.println(table);

        /*BiMap,
            可以通过key得到value，也可以通过value得到key
         */
        HashBiMap<Integer, String> biMap = HashBiMap.create();
        biMap.put(1,"1");
        biMap.put(2,"2");
        Integer integer = biMap.inverse().get("1");
        System.out.println(integer);
    }
}
