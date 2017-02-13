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
    /*
        CacheBuilder配置：
　　1. 大小： CacheBuilder.maximumSize(long)
                        CacheBuilder.weigher(Weigher)
                        CacheBuilder.maxumumWeigher(long)
　　2. 有效期： expireAfterAccess(long, TimeUnit)
                            expireAfterWrite(long, TimeUnit)
　　3. 引用： CacheBuilder.weakKeys()
                        CacheBuilder.weakValues()
                        CacheBuilder.softValues()
　　4. 明确的删除：invalidate(key)
                                  invalidateAll(keys)
                                  invalidateAll()
　　5. 删除监听器：CacheBuilder.removalListener(RemovalListener)

　　缓存刷新：
　　1. LoadingCache.refresh(K)  生成新的value的时，旧的value依然可用
　　2. CacheLoader.reload(K, V) 生成新的value过程中允许使用旧的value
　　3. CacheBuilder.refreshAfterWrite(long, TimeUnit) 自动刷新cache

        主动移除：
　　1.Cache.invalidate(key) 单独移除
　　2.Cache.invalidateAll(keys) 批量移除
　　3.Cache.invalidateAll() 移除所有
     */
    private LoadingCache<String, User> cacher =
            CacheBuilder.newBuilder().build(
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
