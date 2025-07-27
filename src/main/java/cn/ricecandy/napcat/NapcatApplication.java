package cn.ricecandy.napcat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class NapcatApplication {
    public static void main(String[] args) {
        SpringApplication.run(NapcatApplication.class, args);
    }
}
