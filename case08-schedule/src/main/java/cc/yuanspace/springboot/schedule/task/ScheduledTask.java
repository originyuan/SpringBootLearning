package cc.yuanspace.springboot.schedule.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ScheduledTask {

    /**
     * 固定延时
     * 上一任务执行结束后，下一任务才开始计时
     */
    //@Scheduled(fixedDelay = 1000)
    public void fixedDelayTask() {
        System.out.println("fixedDelay " + LocalDateTime.now() + " [" + Thread.currentThread().getName() + "] ");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 固定频率
     * 达到时间间隔时，无论上一次是否执行，本次任务都会执行
     * 如果是同一线程则入队
     */
    //@Scheduled(fixedRate = 1000)
    public void fixedRateTask() {
        System.out.println("fixedRateTask " + LocalDateTime.now() + " [" + Thread.currentThread().getName() + "] ");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * cron 表达式
     *      [* * * * * ?]
     * 表示 [秒 分 时 日 月 周]
     * 	  <li>second</li>
     * 	  <li>minute</li>
     * 	  <li>hour</li>
     * 	  <li>day of month</li>
     * 	  <li>month</li>
     * 	  <li>day of week</li>
     * 日和周有冲突，其中一个必须为 ?
     */
    @Scheduled(cron = "0/1 * * * * ?")
    public void cronTask() {
        System.out.println("cronTask " + LocalDateTime.now() + " [" + Thread.currentThread().getName() + "] ");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
