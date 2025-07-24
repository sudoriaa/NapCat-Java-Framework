package cn.ricecandy.napcat.dto.event.notice;

import cn.ricecandy.napcat.dto.event.OneBotEvent;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class NoticeEvent extends OneBotEvent {
    private String notice_type;
}
