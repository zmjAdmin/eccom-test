package com.eccom.starter.controller;

import com.eccom.starter.common.JsonData;
import com.eccom.starter.task.MyTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private MyTask myTask;

    @RequestMapping("/test")
    public JsonData test() throws InterruptedException, ExecutionException {
        Long start = System.currentTimeMillis();
        myTask.task1();
        myTask.task2();
        myTask.task3();
        Long end = System.currentTimeMillis();
        System.out.println(end-start);
        Future<String> future = myTask.task4();
        Thread.sleep(4000);
        return JsonData.ok(future.get(), end-start);
    }

}
