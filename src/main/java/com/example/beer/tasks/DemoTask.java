package com.example.beer.tasks;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class DemoTask {

    @Value("${task.one.t}")
    private String t;
    @Scheduled(cron = "*/10 * * * * *")
    public void test() {
        System.out.println("i am scheduled" + t);
    }
}
