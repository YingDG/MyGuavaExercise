package yingdg.exercise.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

/**
 * Created by YingDG on 2017/2/10.
 */
public class CacheEx {
    private LoadingCache<String, User> cacher = CacheBuilder.newBuilder().build(
            new CacheLoader<String, User>() {
                // 默认返回
                @Override
                public User load(String key) throws Exception {
                    return new User("b", "b", 2);
                }
            }
    );

    @Test
    public void cacheTest() {
        cacher.put("1", new User("a", "a", 1));

        try {
            User user = cacher.get("1");
            System.out.println(user);

            // not exist in cacher
            User user2 = cacher.get("2");
            System.out.println(user2);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
