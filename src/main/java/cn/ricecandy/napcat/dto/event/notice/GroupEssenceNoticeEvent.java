package cn.ricecandy.napcat.dto.event.notice;
// 群精华

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GroupEssenceNoticeEvent extends NoticeEvent{
    private String message_id;
    private String sender_id;
    private String operator_id;
    private String sub_type;
}
