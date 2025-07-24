package cn.ricecandy.napcat.dto.event.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class GroupRequestEvent extends RequestEvent {
    private String sub_type;     // "add"(加群申请)或"invite"(被邀请入群)
    private String group_id;       // 群号
    private String flag;
}