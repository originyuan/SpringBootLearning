package cc.yuanspace.springboot.async.controller;

import cc.yuanspace.springboot.async.service.AsyncTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
public class TaskController {
    @Autowired
    AsyncTaskService asyncTaskService;

    @RequestMapping("/task")
    public void task() {
        System.out.println("controller 调度：");
        System.out.println("task1 执行");
        asyncTaskService.task1();

        System.out.println();
        System.out.println("task2 执行");
        asyncTaskService.task2();

        System.out.println();
        System.out.println("task2 再次执行，直接获取返回值");
        Object o = asyncTaskService.task2();
        System.out.println("第二次执行任务2 返回" + o);

        System.out.println();
        System.out.println("futureResultTask 执行，获取 future");
        Future<Object> objectFuture = asyncTaskService.futureResultTask();
        try {
            System.out.println("futureResultTask 返回" + objectFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("controller 方法结束。。。。");
    }

    @RequestMapping("/futureResultTask")
    public void futureResultTask() {

        System.out.println("futureResultTask 执行，获取 future");
        Future<Object> objectFuture = asyncTaskService.futureResultTask();
        try {
            System.out.println("futureResultTask 返回" + objectFuture.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("controller 方法结束。。。。");
    }

    @RequestMapping("/listenableFutureResultTask")
    public void listenableFutureResultTask() {

        System.out.println("listenableFutureResultTask 执行，获取 future");
        ListenableFuture<Object> objectFuture = asyncTaskService.listenableFutureResultTask();
        objectFuture.addCallback(new ListenableFutureCallback<Object>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("listenableFutureResultTask 执行失败");
            }

            @Override
            public void onSuccess(Object result) {
                System.out.println("listenableFutureResultTask 执行成功 返回 "+result);
            }
        });
//        try {
//            // 这里调 get 会阻塞等待结果返回，依然会执行上面的回调
//            objectFuture.get();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
        System.out.println("controller 方法结束。。。。");
    }


}
