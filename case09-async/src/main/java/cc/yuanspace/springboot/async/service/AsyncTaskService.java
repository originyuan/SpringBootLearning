package cc.yuanspace.springboot.async.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Service
public class AsyncTaskService {

    @Async
    public void task1() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " task1");
    }

    /**
     * 直接返回结果是不起作用的，会被忽略
     * 调用方会获得 null 值结果
     */
    @Async
    public Object task2() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " task2");
        return "test2";
    }

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
}
