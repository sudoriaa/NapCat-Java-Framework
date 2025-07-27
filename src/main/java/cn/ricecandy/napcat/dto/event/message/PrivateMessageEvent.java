package cn.ricecandy.napcat.dto.event.message;

import cn.ricecandy.napcat.entity.sender.Sender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class PrivateMessageEvent extends MessageEvent {
    private String sub_type; //
    private String target_id; // 临时会话目标QQ号
    private String temp_source; // 临时会话来源
    private Sender sender;
}
