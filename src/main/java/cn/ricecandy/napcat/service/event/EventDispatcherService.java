package cn.ricecandy.napcat.service.event;

import cn.ricecandy.napcat.dto.event.OneBotEvent;
import cn.ricecandy.napcat.dto.event.message.GroupMessageEvent;
import cn.ricecandy.napcat.dto.event.message.MessageEvent;
import cn.ricecandy.napcat.dto.event.message.PrivateMessageEvent;
import cn.ricecandy.napcat.service.api.MessageApiService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EventDispatcherService {

    @Resource
    private PrivateMessageService privateMessageService;
    @Resource
    private GroupMessageService groupMessageService;
    @Resource
    private MessageApiService messageApiService;


    public Object dispatch(String data) {
        OneBotEvent oneBotEvent = JSON.parseObject(data, OneBotEvent.class);

        switch (oneBotEvent.getPost_type()){
            case MESSAGE -> {
                MessageEvent messageEvent = JSON.parseObject(data, MessageEvent.class);
                switch (messageEvent.getMessage_type()) {
                    case GROUP -> {
                        GroupMessageEvent groupMessageEvent = JSONObject.parseObject(data, GroupMessageEvent.class);
                        groupMessageService.onGroupMessage(groupMessageEvent);
                        log.info("[↓收到群消息]群聊:({}) | 发送人:{} -> {}", groupMessageEvent.getGroup_id(), groupMessageEvent.getSender().getUserId(), groupMessageEvent.getRaw_message());
                    }

                    case PRIVATE -> {
                        PrivateMessageEvent privateMessageEvent = JSONObject.parseObject(data, PrivateMessageEvent.class);
                        privateMessageService.onPrivateMessage(privateMessageEvent);
                        log.info("[↓收到私聊消息]发送人:{} -> {}", privateMessageEvent.getSender().getUserId(), privateMessageEvent.getRaw_message());
                    }
                }
            }
            case NOTICE -> {

            }
        }
        return null;
    }
}