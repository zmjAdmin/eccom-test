package com.eccom.starter.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
@Async
public class MyTask {

    public void task1() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("task1");
    }

    public void task2() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("task2");
    }

    public void task3() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("task3");
    }

    public Future<String> task4() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("task4");
        return new AsyncResult<String>("task4");
    }

}
