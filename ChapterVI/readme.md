`缓存`

缓存在很多系统和架构中的种类：
   
   1.CPU缓存
   
   2.操作系统缓存
   
   3.本地缓存
   
   4.分布式缓存
   
   5.HTTP缓存
   
   6.数据库缓存

JavaSE: 
   ConcurrentHashMap(一直保存所有添加的元素，直到显式地移除)

Guava Cache 适用于：

    通过消耗一些内存空间提升速度；
    
    预料某些数据会被多次查询；
    
    缓存中存放的数据总量一定不会超出内存容量；
    
    Guava Cache 是单个应用运行时的本地内存缓存

CacheBuilder：构建缓存对象及参数

Cache：缓存操作类

LoadingCache

CacheLoader：缓存不存在时实现自动加载缓存（返回默认值）

MapMaker

CacheBuilderSpec：用于构建CacheBuilder时的配置描述

CacheStats：用于收集缓存信息

RemovalListener类： 用于监听Cache中的key的移除

RemovalNotification

RemovalListeners类：异步执行RemovalListener的onRemoval触发动作