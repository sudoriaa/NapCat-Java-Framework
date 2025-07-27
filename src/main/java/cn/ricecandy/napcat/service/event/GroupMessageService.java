package cn.ricecandy.napcat.service.event;

import cn.ricecandy.napcat.dto.event.message.GroupMessageEvent;

public interface GroupMessageService {
    public Integer onGroupMessage(GroupMessageEvent event);
}
