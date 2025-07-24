package cn.ricecandy.napcat.service.event.impl;

import cn.ricecandy.napcat.dto.api.req.MessageApiReq;
import cn.ricecandy.napcat.dto.event.message.GroupMessageEvent;
import cn.ricecandy.napcat.service.api.MessageApiService;
import cn.ricecandy.napcat.service.event.GroupMessageService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GroupMessageServiceImpl implements GroupMessageService {

    @Resource
    private MessageApiService msgApi;

    @Override
    public Integer groupMessageEvent(GroupMessageEvent event) {
        if(event.getGroup_id().equals("894100267")){
            MessageApiReq req = MessageApiReq.builder()
                    .group_id(event.getGroup_id())
                    .message("你发了"+event.getRaw_message()+"|"+event.getMessage_id())
                    .build();
            msgApi.sendGroupMsg(req).subscribe();
        }
        return 0;
    }
}
