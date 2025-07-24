package cn.ricecandy.napcat.dto.event.notice;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProfileLikeNoticeEvent extends NoticeEvent {
    private String operator_id;
    private String operator_nick;
    private Integer times;
    private Long time;
}
