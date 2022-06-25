### 异步任务

#### 开启异步 @EnableAsync
在配置类上添加注解 @EnableAsync
```java
// 开启异步任务
@EnableAsync
@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

        System.out.println("***** 启动成功 *************");
    }

}
```

#### 指定异步调度方法 @Async
方法上标记 @Async 注解，对于无返回值的，直接标记调用即可异步执行了
```java
    @Async
    public void task1() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " task1");
    }
```

对于有返回的值的方法，直接返回数据是无效的，会被忽略，调用方会直接返回一个`null`。
可以返回一个 Future 用于获取返回值，方法 return 一个 `AsyncResult.forValue(res)`。
```java
    /**
     * 使用 Future 承载返回数据
     * spring 提供了 AsyncResult 类用于返回结果
     * 调用方调用 Future#get 方法获取结果，同步等待返回
     */
    @Async
    public Future<Object> futureResultTask() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " futureResultTask");
        return AsyncResult.forValue("futureResultTask res");
    }

    /**
     * 返回一个 ListenableFuture 对象，调用方可以设置回调方法，等任务完成自动处理结果
     * 也可以像普通Future一样调用get方法，同步等待
     */
    @Async
    public ListenableFuture<Object> listenableFutureResultTask() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " listenableFutureResultTask");
        return AsyncResult.forValue("listenableFutureResultTask res");
    }
```

#### 自定义线程池
可以配置一个线程池，自定义线程参数，使用`ThreadPoolTaskExecutor`
```java
@Configuration
public class AsyncConfig {
    @Bean
    public ThreadPoolTaskExecutor asyncServiceExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(8);
        //配置最大线程数
        executor.setMaxPoolSize(8);
        //配置队列大小
        executor.setQueueCapacity(100);
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix("async-pool-");
        // 设置拒绝策略：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //执行初始化
        executor.initialize();
        return executor;
    }

}
```

#### 异常处理