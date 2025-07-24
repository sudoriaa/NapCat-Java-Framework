package cn.ricecandy.napcat.dto.event.notice;
// 好友消息撤回

import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class FriendRecallNoticeEvent extends NoticeEvent{
    private String user_id;
    private String message_id;
}
