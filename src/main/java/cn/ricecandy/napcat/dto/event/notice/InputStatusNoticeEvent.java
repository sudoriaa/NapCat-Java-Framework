package cn.ricecandy.napcat.dto.event.notice;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class InputStatusNoticeEvent extends NoticeEvent {
    private String status_text;
    private int event_type;
    private String user_id;
    private String group_id; // 使用包装类型表示可能为null
}
