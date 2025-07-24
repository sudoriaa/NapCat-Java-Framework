package cn.ricecandy.napcat.dto.event.notice;
// 群禁言

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GroupBanNoticeEvent extends GroupNoticeEvent{
    private String operator_id;
    private Long duration;
    private String sub_type;
}
