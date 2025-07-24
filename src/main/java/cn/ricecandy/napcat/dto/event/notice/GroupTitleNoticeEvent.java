package cn.ricecandy.napcat.dto.event.notice;
// 群头衔变更通知


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GroupTitleNoticeEvent extends GroupNoticeEvent {
    private String title;
}