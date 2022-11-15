package io.dbsdud.schedulepicker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class SchedulePickerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchedulePickerApplication.class, args);
    }

}
