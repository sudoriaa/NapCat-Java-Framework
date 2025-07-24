package cn.ricecandy.napcat.dto.event.message;

import cn.ricecandy.napcat.dto.event.OneBotEvent;
import cn.ricecandy.napcat.enums.MessageType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MessageEvent extends OneBotEvent {
    private MessageType message_type; // 'private' or 'group'
    private String message_id;
    private String user_id;
    private List<Segment> message;
    private String raw_message;
    private Integer font;
}
