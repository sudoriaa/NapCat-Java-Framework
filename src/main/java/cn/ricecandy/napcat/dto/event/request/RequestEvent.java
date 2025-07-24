package cn.ricecandy.napcat.dto.event.request;

import cn.ricecandy.napcat.dto.event.OneBotEvent;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RequestEvent extends OneBotEvent {
    private String request_type; // "friend"或"group"
    private String flag;        // 请求flag
    private String user_id;        // 发送请求的QQ号
    private String comment;     // 验证信息
}