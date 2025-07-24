package cn.ricecandy.napcat.dto.event.notice;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public abstract class GroupNoticeEvent extends NoticeEvent {
    protected String group_id;
    protected String user_id;

}
