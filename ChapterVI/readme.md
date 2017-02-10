`缓存`

缓存在很多系统和架构中都有用：
        1.CPU缓存
　　2.操作系统缓存
　　3.本地缓存
　　4.分布式缓存
　　5.HTTP缓存
　　6.数据库缓存

JavaSE: ConcurrentHashMap(一直保存所有添加的元素，直到显式地移除)

Guava Cache 适用于：
    通过消耗一些内存空间提升速度；
    预料某些数据会被多次查询；
    缓存中存放的数据总量一定不会超出内存容量；
    Guava Cache 是单个应用运行时的本地内存缓存

CacheBuilder

LoadingCache

CacheLoader