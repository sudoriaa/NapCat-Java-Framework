package cn.ricecandy.napcat.dto.event.notice;
// 群名称变动

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GroupNameNoticeEvent extends GroupNoticeEvent {
    private String name_new;
}