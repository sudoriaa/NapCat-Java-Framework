package cn.ricecandy.napcat.controller;


import cn.ricecandy.napcat.service.event.EventDispatcherService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@Slf4j
public class HttpController {
    @Resource
    private EventDispatcherService eventDispatcherService;

    @Async
    @PostMapping("/sudoria")
    public void handleEvent(
            @RequestHeader HttpHeaders headers,
            @RequestBody String body) {
            eventDispatcherService.dispatch(body);
    }
}
