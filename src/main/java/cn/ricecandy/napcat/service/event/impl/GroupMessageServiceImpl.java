package cn.ricecandy.napcat.service.event.impl;

import cn.ricecandy.napcat.dto.api.req.MessageApiReq;
import cn.ricecandy.napcat.dto.event.message.GroupMessageEvent;
import cn.ricecandy.napcat.service.api.MessageApiService;
import cn.ricecandy.napcat.service.event.GroupMessageService;
import com.alibaba.fastjson.JSONObject;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GroupMessageServiceImpl implements GroupMessageService {

    @Resource
    private MessageApiService msgApi;

    @Override
    public Integer onGroupMessage(GroupMessageEvent event) {
        if(event.getGroup_id().equals("894100267")){


            MessageApiReq req = MessageApiReq.builder()
                    .message_id(event.getMessage_id())
                    .build();
            msgApi.getMsg(req).subscribe(
                    resp -> {
                        MessageApiReq req_ = MessageApiReq.builder()
                                .group_id(event.getGroup_id())
                                .message(JSONObject.toJSONString(resp))
                                .build();
                        msgApi.sendGroupMsg(req_).subscribe();
                    }
            );

        }
        return 0;
    }
}
