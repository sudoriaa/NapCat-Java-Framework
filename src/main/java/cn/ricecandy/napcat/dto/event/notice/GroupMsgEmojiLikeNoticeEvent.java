package cn.ricecandy.napcat.dto.event.notice;
// 	群表情回应

import cn.ricecandy.napcat.entity.MsgEmojiLike;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GroupMsgEmojiLikeNoticeEvent extends GroupNoticeEvent{
    private String message_id;
    private List<MsgEmojiLike> likes;
}
