package cn.ricecandy.napcat.dto.event.notice;
// 群成员增加


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GroupIncreaseNoticeEvent extends GroupNoticeEvent {
    private String operator_id;
    private String sub_type; // "approve" or "invite"
}
