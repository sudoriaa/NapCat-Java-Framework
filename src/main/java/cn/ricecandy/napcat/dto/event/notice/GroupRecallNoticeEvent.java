package cn.ricecandy.napcat.dto.event.notice;
// 群消息撤回

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GroupRecallNoticeEvent extends GroupNoticeEvent{
    private String operator_id;
    private String message_id;
}
