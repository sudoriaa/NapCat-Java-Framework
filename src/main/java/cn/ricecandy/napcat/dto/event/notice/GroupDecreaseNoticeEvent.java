package cn.ricecandy.napcat.dto.event.notice;
// 群成员减少



import cn.ricecandy.napcat.enums.GroupDecreaseSubType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GroupDecreaseNoticeEvent extends GroupNoticeEvent{
    private GroupDecreaseSubType subType;
    private String operatorId;
}
