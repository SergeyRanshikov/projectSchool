package com.projectSchool.projectSchool.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping("/info")
public class InfoController {
    public static final Logger logger = LoggerFactory.getLogger(InfoController.class);

    @Value("${server.port:-1}")
    private int port;

    @GetMapping("port")
    public int getPort() {
        return port;
    }

    @GetMapping("/calculate")
    public void calculate() {
        long startTime = System.currentTimeMillis();
        Stream.iterate(1, a->a+1)
                .limit(1_000_000)
                .reduce(0, (a,b) -> a + b);
        long timeConsumed = System.currentTimeMillis()- startTime;
        logger.info("время работы " + timeConsumed);


        startTime = System.currentTimeMillis();
        Stream.iterate(1, a->a+1)
                .parallel()
                .limit(1_000_000)
                .reduce(0, (a,b) -> a + b);
        timeConsumed = System.currentTimeMillis()- startTime;
        logger.info("время работы после оптимизации" + timeConsumed);


    }
}
