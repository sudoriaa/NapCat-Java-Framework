package cn.ricecandy.napcat.dto.event.notice;
// 新添加好友

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class FriendAddNoticeEvent extends NoticeEvent{
    private String user_id;
}
