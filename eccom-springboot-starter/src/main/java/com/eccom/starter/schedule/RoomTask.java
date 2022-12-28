package com.eccom.starter.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RoomTask {

    // @Scheduled(fixedRate = 2000)
    // @Scheduled(fixedDelay = 4000)
    // @Scheduled(cron = "*/1 * * * * *")
    public void sum() {
        System.out.println("房间数：" + new Random().nextInt());
    }

}
