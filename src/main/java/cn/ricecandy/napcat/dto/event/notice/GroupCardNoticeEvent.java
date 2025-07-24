package cn.ricecandy.napcat.dto.event.notice;
// 群名片变更

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GroupCardNoticeEvent extends GroupNoticeEvent{
    private String card_new;
    private String card_old;
}
