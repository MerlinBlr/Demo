package com.fortech.demo.sheduler;

import com.fortech.demo.services.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@RequiredArgsConstructor
@Component
public class ScheduledTasks {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private final ProductService productService;

    @Scheduled(fixedDelay = 180000, initialDelay = 10000)
    public void createProductsOnSchedule() {
        log.info("Job was performed now {}", dateFormat.format(new Date()));
        productService.createProductsOnSchedule();
    }

}
