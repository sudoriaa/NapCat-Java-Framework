package cn.ricecandy.napcat.service.event.impl;

import cn.ricecandy.napcat.dto.api.req.MessageApiReq;
import cn.ricecandy.napcat.dto.event.message.PrivateMessageEvent;
import cn.ricecandy.napcat.service.api.MessageApiService;
import cn.ricecandy.napcat.service.event.PrivateMessageService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class PrivateMessageServiceImpl implements PrivateMessageService {
    @Resource
    private MessageApiService msgApi;


    @Override
    public Integer privateMessageEvent(PrivateMessageEvent event) {

        if(event.getUser_id().equals("3078037152")){
            MessageApiReq req = MessageApiReq.builder()
                    .user_id(event.getUser_id())
                    .message("你发了"+event.getRaw_message())
                    .build();
            msgApi.sendPrivateMsg(req).subscribe();

            req = MessageApiReq.builder()
                    .user_id("3078037152")
                    .build();
            msgApi.friendPoke(req).subscribe();
        }

        return 0;
    }
}
