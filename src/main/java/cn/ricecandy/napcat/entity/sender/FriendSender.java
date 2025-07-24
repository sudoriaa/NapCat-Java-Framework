package cn.ricecandy.napcat.entity.sender;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class FriendSender extends Sender {
    private String groupId; // 临时会话群号（可选）
}
