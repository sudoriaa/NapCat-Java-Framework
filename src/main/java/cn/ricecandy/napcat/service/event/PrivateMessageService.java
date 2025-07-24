package cn.ricecandy.napcat.service.event;

import cn.ricecandy.napcat.dto.event.message.PrivateMessageEvent;

public interface PrivateMessageService {
    public Integer privateMessageEvent(PrivateMessageEvent event);
}
