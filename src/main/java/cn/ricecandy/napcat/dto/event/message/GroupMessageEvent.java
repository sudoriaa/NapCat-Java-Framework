package cn.ricecandy.napcat.dto.event.message;

import cn.ricecandy.napcat.entity.sender.GroupSender;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GroupMessageEvent extends MessageEvent {
    private String sub_type; // 'normal' or 'anonymous' or 'notice'
    private String group_id; // 群号
    private GroupSender sender;
}
