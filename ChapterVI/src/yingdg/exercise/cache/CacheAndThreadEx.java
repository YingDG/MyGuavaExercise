package yingdg.exercise.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by YingDG on 2017/2/13.
 */
public class CacheAndThreadEx<K, V> {
    private Cache<K, V> cacher = CacheBuilder.newBuilder()
            .maximumSize(8)
            // .expireAfterAccess(10, TimeUnit.MINUTES)
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .build();

    public Object getObjectByCache(K key, String threadName) {
        System.out.println("ThreadName: " + threadName);

        Object obj = null;
        try {
            // cacher.put(key, (V) threadName);
            obj = cacher.get(key, new Callable<V>() {
                @Override
                public V call() throws Exception {
                    // 默认返回
                    return (V) "缓存";
                }
            });
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return obj;
    }

    public static void main(String[] args) {
        final CacheAndThreadEx<String, String> cacheAndThreadEx = new CacheAndThreadEx();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("T1 goes.");
                Object o = cacheAndThreadEx.getObjectByCache("key", "t1");
                System.out.println(o);
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("T2 goes.");
                Object o = cacheAndThreadEx.getObjectByCache("key", "t2");
                System.out.println(o);
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("T3 goes.");
                Object o = cacheAndThreadEx.getObjectByCache("key", "t3");
                System.out.println(o);
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
